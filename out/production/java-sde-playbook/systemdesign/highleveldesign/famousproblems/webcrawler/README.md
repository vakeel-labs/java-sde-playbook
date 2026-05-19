# Web Crawler

## Scale
Crawl 1 billion web pages in 1 month, refresh every 2 weeks, respect robots.txt, handle duplicates

## Core Challenges
URL deduplication at scale (1B+ URLs), politeness (rate limiting per domain), distributed coordination, content extraction

## System Overview (Infrastructure, not user-facing)
- Input: Seed URLs list
- Output: Crawled page content stored in blob storage, ready for indexing pipeline

## Core Components
- **URL Frontier** - Priority queue of URLs to crawl; partitioned by domain hash across worker nodes; backed by Kafka topics
- **Fetcher Workers** - Download HTML via HTTP; respect robots.txt (cache robots.txt per domain); rate limit per domain
- **DNS Cache** - Shared DNS resolution cache across workers; avoids DNS lookup bottleneck
- **Content Store** - Raw HTML stored in S3/GCS with URL + crawl timestamp as metadata
- **URL Extractor** - Parse HTML with jsoup; extract all href links; normalize URLs (resolve relative, remove fragments)
- **URL Deduplicator** - Two-level: Bloom filter (fast probabilistic) -> Redis set (exact for URLs passing Bloom filter)
- **Politeness Scheduler** - Per-domain rate limiter; ensures minimum delay (1-2 seconds) between requests to same domain
- **Content Deduplicator** - SimHash of content body to detect near-duplicate pages; skip if similarity > threshold

## Deep Dive
- **URL deduplication at scale**: Bloom filter holds 1B URLs in ~1.2GB RAM (with 1% false positive rate). A false positive means we skip re-crawling a URL we've actually not seen - acceptable for crawling. Exact deduplication for URLs passing Bloom filter uses Redis with URL hashes.
- **Politeness**: Each domain assigned to a specific worker (consistent hashing on domain -> worker). Worker maintains a per-domain queue and enforces 1-2 second delay between requests. Prevents overwhelming any single server and avoids IP blocks.
- **Crawl priority**: High-priority URLs (high PageRank, frequently updated news sites) placed in high-priority Kafka topic; long-tail URLs in low-priority topic. Priority based on: domain authority, content freshness signals, link popularity.
- **Content deduplication**: SimHash generates a 64-bit fingerprint of page content. Pages with Hamming distance < 3 are near-duplicates. SimHash of all crawled pages stored in-memory (64-bit x 1B pages = 8GB).
- **robots.txt compliance**: Fetch and cache robots.txt per domain at start of crawl session; refresh every 24h. Never violate crawl-delay directive.

## Key Trade-offs
- Breadth-first vs best-first crawling: BFS finds more unique pages early; best-first (by PageRank) finds higher quality pages early. Hybrid approach by priority queue.
- Politeness vs crawl speed: longer delay = more polite but slower coverage. 1-2 seconds per domain is the standard courtesy delay.
- Storage format: raw HTML (flexible, reprocessable) vs extracted text (smaller, loses structure). Raw HTML preferred for flexibility.
