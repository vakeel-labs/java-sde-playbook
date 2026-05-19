# WhatsApp (Real-time Messaging)

## Scale
2B users, 100B messages/day, < 100ms message delivery, end-to-end encryption, 500M groups

## Core Challenges
Real-time delivery, offline message queuing, delivery receipts (sent/delivered/read), group chats at scale

## APIs (WebSocket-based)
- WebSocket connection established on app open; connection maintained with heartbeat
- SEND message { to_user_id, content, type, client_msg_id } -> message_id
- GET /messages/{thread_id}?before=timestamp -> paginated message history
- ACK { message_id, status } -> marks as delivered or read

## Core Components
- **WebSocket Gateway** - Persistent connections; one connection per active user; routes messages
- **Chat Service** - Handles message sending; persists to message store; pushes to recipient
- **Message Store** - Cassandra (partition by thread_id, cluster by timestamp); messages kept 30 days
- **Presence Service** - Tracks online/offline/last-seen (Redis with TTL heartbeat)
- **Notification Service** - Push notifications (FCM/APNs) for offline users
- **Group Service** - Manages group membership; fan-out messages to all members

## Deep Dive
- **Message flow**: Sender -> WebSocket Gateway -> Chat Service -> store in Cassandra -> if recipient online push via WebSocket; if offline queue in Redis and send push notification
- **Delivery receipts**: Single checkmark = server received; double checkmark = device received (client sends ACK); blue double = read (client sends read receipt)
- **Group messaging**: For small groups (<= 256): fan-out to each member's message queue. For large groups: recipients pull on reconnect.
- **End-to-End Encryption**: Signal Protocol; private keys never leave device; server stores only encrypted blobs; even WhatsApp cannot read messages

## Key Trade-offs
- Push vs pull for offline messages: push (lower latency when online) + queue (reliability when offline)
- Message retention: 30-day retention balances storage cost vs user expectation
- Group size limit: 1024 member limit balances fan-out cost vs group utility
