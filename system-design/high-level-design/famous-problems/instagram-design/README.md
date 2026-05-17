# Instagram (Photo/Video Social Platform)

## Scale
1B users, 100M photos/videos uploaded per day, 500M daily Story viewers, celebrities with 300M+ followers

## Core Challenges
Photo/video storage, news feed generation (same as Twitter), social graph at scale, Stories with 24h TTL

## APIs
- POST /media/upload { file, caption, tags, location? } -> media_id
- GET /feed -> personalized home feed (posts from followed accounts)
- POST /media/{id}/like
- POST /follow/{user_id}
- GET /stories/{user_id} -> list of active story items (< 24h old)
- GET /explore -> ML-driven discover feed

## Core Components
- **Upload Service** - Receive media; store original in S3; trigger async processing pipeline
- **Media Processing Service** - Generate thumbnails, multiple resolutions; video transcoding; output to S3; CDN invalidation
- **Social Graph Service** - Follower/following relationships in Cassandra; following list cached in Redis
- **Feed Service** - Hybrid fan-out (push for regular users, pull for accounts with 10K+ followers)
- **Timeline Cache (Redis)** - List of post IDs per user (capped at 1000 most recent)
- **Stories Service** - Separate from posts; Cassandra with TTL on story items; ordered by recency

## Deep Dive
- **Same push/pull hybrid as Twitter**: Regular accounts use fan-out on write (push post_id to followers' feed caches). Celebrity accounts use fan-out on read (fetched and merged at read time).
- **Stories**: Stored in Cassandra with expiry_time = created_at + 24h. Background job deletes expired stories. Feed shows stories sorted by account relevance, not chronological.
- **Explore Page**: ML model predicts engagement probability for each (user, post) pair. Pre-computed recommendations stored in Redis. Refreshed every few hours.
- **Hashtag search**: Elasticsearch inverted index on hashtags; top posts per hashtag cached in Redis (updated on high engagement).

## Key Trade-offs
- Stories vs posts: different storage (TTL) and feed logic (chronological vs ranked)
- Explore feed: pre-computation (fast read, potentially stale) vs real-time (slow read, always fresh)
- Fan-out vs fan-in for feed: same trade-off as Twitter
