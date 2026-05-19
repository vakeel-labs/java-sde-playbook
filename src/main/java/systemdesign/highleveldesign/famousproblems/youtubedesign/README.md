# YouTube (Video Streaming Platform)

## Scale
2B users, 500 hours of video uploaded per minute, 1B hours watched per day

## Core Challenges
Video upload and transcoding pipeline, adaptive streaming, global CDN delivery, recommendation engine

## APIs
- POST /videos/upload { title, description, file } -> video_id (async processing begins)
- GET /videos/{video_id}/manifest -> HLS/DASH manifest file
- GET /videos/{video_id} -> metadata (title, views, likes, description)
- POST /videos/{video_id}/like
- GET /feed -> personalized recommendations

## Core Components
- **Upload Service** - Receive raw video; store in blob storage (S3); push to transcoding queue (Kafka)
- **Transcoding Service** - Convert to multiple resolutions (360p, 720p, 1080p, 4K) and formats (H.264, VP9, AV1); distributed worker pool
- **Video Storage** - S3 for raw and transcoded video chunks
- **CDN** - Distribute video chunks to edge nodes globally (YouTube uses Google's own CDN)
- **Metadata Service** - Video info in PostgreSQL; view counts in Redis (batched writes to DB)
- **Recommendation Service** - ML-based, pre-computed recommendations stored in Redis

## Deep Dive
- **Adaptive Bitrate Streaming (ABR)**: HLS/MPEG-DASH splits video into 2-10 second chunks at multiple bitrates. Player switches quality segment-by-segment based on measured bandwidth.
- **Transcoding pipeline**: Kafka-driven worker pool; each worker picks up a transcoding job; multiple resolutions transcoded in parallel; output stored to S3; CDN cache invalidated.
- **View Count at Scale**: Redis INCR command (atomic); batch-flush to DB every N seconds. Approximate count is displayed; exact count reconciled later.
- **Resumable Upload**: Video upload split into chunks (e.g., 5MB each). Each chunk uploaded separately with sequence number. If connection drops, resume from last successful chunk.

## Key Trade-offs
- Transcoding: synchronous (user waits) vs async (better UX, video available faster for processing)
- CDN vs origin serving: CDN for 99%+ of traffic; origin only for fresh/unpopular content
- Exact vs approximate view counts: approximate is fine for display; exact needed for monetization
