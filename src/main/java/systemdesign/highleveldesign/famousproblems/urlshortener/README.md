# URL Shortener (TinyURL / Bit.ly)

## Scale
1 billion URLs shortened, 100:1 read-to-write ratio, URLs expire after N days

## Core Challenges
Unique short ID generation, fast redirection (< 10ms), analytics tracking, custom aliases

## APIs
- POST /shorten { original_url, custom_alias?, expiry_days? } -> short_url
- GET /{short_code} -> 301/302 redirect to original URL
- GET /analytics/{short_code} -> click count, referrers, geo data

## Core Components
- **URL Generator Service** - Encodes a unique ID to Base62 (a-z, A-Z, 0-9) -> 7-char short code
- **Database** - SQL (MySQL/PostgreSQL) for URL mappings; unique constraint on short_code
- **Cache (Redis)** - Cache short_code -> original_url with TTL; cache hit on 99%+ of reads
- **Redirection Service** - Stateless; checks cache -> DB -> 301 redirect
- **Analytics Service** - Async event processing (Kafka) for click tracking

## Deep Dive
- **ID Generation**: Auto-increment ID encoded to Base62 gives 11+ trillion combinations with 7 chars
- **301 vs 302 Redirect**: 301 (permanent) -> browser caches it (fewer requests); 302 (temporary) -> every click hits server (needed for analytics)
- **Custom aliases**: Store as-is; check uniqueness in DB with unique constraint
- **Expiry**: Store expiry_date in DB; use Redis TTL; background job for DB cleanup
- **High availability**: Multiple stateless redirect servers behind load balancer

## Key Trade-offs
- 301 vs 302: performance (301) vs analytics accuracy (302)
- Single DB vs distributed: at this scale a single primary + read replicas is sufficient
- Encoding scheme: Base62 (alphanumeric only) vs Base64 (includes +/ which are URL-unsafe)
