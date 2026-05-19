# Netflix (Video Streaming Service)

## Scale
230M subscribers, 15% of global internet traffic, 200+ countries, 1000+ device types, 4K/HDR streaming

## Core Challenges
Video encoding pipeline, proprietary CDN (Open Connect), personalized recommendations, resilience engineering

## APIs
- GET /catalog -> personalized content grid (title, thumbnail, match percentage)
- GET /content/{id}/manifest -> HLS/DASH adaptive streaming manifest
- POST /playback/start { content_id, profile_id, device_type }
- POST /playback/heartbeat { position, quality, buffering_events }
- GET /recommendations -> personalized rows (Trending, Because You Watched X, etc.)

## Core Components
- **Content Ingestion Pipeline** - Studios upload master files; encoding farm creates 2200+ bitrate/resolution/codec combinations; stored in S3
- **Netflix Open Connect CDN** - Netflix's own CDN; ISP-deployed appliances (OCA) in 1000+ locations; proactive content pre-caching at night
- **Playback Service** - Returns optimal OCA URL for the user's ISP + device + network; returns adaptive manifest
- **Recommendation Engine** - Collaborative filtering + content-based; trained on Apache Spark; predictions stored in Cassandra; served via Recommendation API
- **API Gateway (Zuul)** - Routes device-specific requests; handles auth; protocol translation
- **Eventing Pipeline (Keystone)** - Kafka-based; 700B+ events/day; drives recommendations, analytics, billing

## Deep Dive
- **Adaptive Bitrate Streaming**: HLS/DASH manifest lists all quality variants. Netflix player algorithm (Bandwidth-Buffer-Algorithm) selects segment quality based on measured throughput and buffer level. Typically starts at low quality, ramps up quickly.
- **Open Connect CDN**: Netflix partners with ISPs to place OCA servers inside ISP networks. Content pre-positioned using a proprietary algorithm that predicts what subscribers will watch next day. Reduces ISP interconnect costs and improves streaming quality.
- **Chaos Engineering**: Netflix Chaos Monkey randomly kills EC2 instances in production. Chaos Gorilla kills entire AWS availability zones. Forces engineers to design for failure as the norm, not the exception. Result: extremely resilient microservices architecture.
- **Personalization**: Every element is personalized - not just recommendations but also which artwork/thumbnail is shown for each title (A/B tested per user segment using multi-armed bandit algorithms).

## Key Trade-offs
- CDN vs origin: Open Connect handles 96%+ of traffic; origin S3 only for cache misses (rare)
- Encoding breadth: 2200+ variants (device x resolution x codec x HDR) ensures optimal quality everywhere at cost of enormous storage
- Resilience: "Design for failure" (Hystrix circuit breakers, Chaos Engineering) vs simplicity
