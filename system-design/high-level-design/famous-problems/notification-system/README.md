# Notification System

## Scale
1B users, 10M notifications/day, multi-channel (push, SMS, email, in-app), priority handling, delivery tracking

## Core Challenges
Multi-channel delivery with different providers, user preference management, rate limiting per user, delivery reliability

## APIs
- POST /notifications/send { user_id, type, channel, content, priority } -> notification_id
- POST /notifications/send-bulk { user_ids[], template_id, data } -> batch_id
- GET /notifications/{user_id}?unread=true -> notification list with pagination
- PUT /notifications/{id}/read
- PUT /users/{id}/preferences { channels, categories, quiet_hours }

## Core Components
- **Notification API** - Accepts send requests; validates; checks user preferences; enqueues to priority topic
- **Priority Queues (Kafka)** - Three topics: HIGH (OTP, security alerts), MEDIUM (transactional), LOW (marketing/promotional)
- **Push Notification Worker** - Integrates with FCM (Android) and APNs (iOS); manages device token lifecycle
- **SMS Worker** - Integrates with Twilio/SNS; handles delivery status callbacks
- **Email Worker** - Integrates with SendGrid/SES; handles bounce and unsubscribe handling
- **User Preference Service** - Stores opt-in/opt-out, channel preferences, quiet hours; checked before sending
- **Delivery Tracker** - Stores (notification_id, user_id, channel, status, timestamp); enables delivery analytics
- **Template Service** - Stores notification templates; substitutes variables; supports i18n

## Deep Dive
- **Priority flow**: OTP and security alerts bypass rate limits and quiet hours. Transactional (order updates) respect rate limits but not quiet hours. Marketing notifications respect both rate limits and quiet hours.
- **Rate limiting**: Per-user, per-channel daily limits stored in Redis (INCR with TTL). Marketing: max 3/day. Transactional: max 20/day. High priority: unlimited.
- **Push delivery**: Device token stored in DB; on send, lookup token -> call FCM/APNs API. Token errors trigger token refresh. Delivery receipt from FCM/APNs updates status.
- **Quiet hours**: Notifications arriving during quiet hours are not dropped - they are re-queued with a delayed delivery time (next window open time). Redis sorted set by delivery_timestamp enables efficient scheduling.
- **Retry logic**: Exponential backoff: 1min -> 5min -> 30min -> dead letter queue after 3 failures.

## Key Trade-offs
- Fire-and-forget vs guaranteed delivery: HIGH priority needs guaranteed delivery with retry; LOW priority (marketing) can be best-effort
- Real-time vs batching: individual sends for HIGH priority; batch sends for marketing (cost efficiency)
- Multi-channel vs single channel: try push first; fall back to SMS for critical notifications if push fails
