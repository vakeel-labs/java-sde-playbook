# Redis

Redis (Remote Dictionary Server) is an in-memory data structure store used as a cache, message broker, and real-time leaderboard engine. It is the go-to solution for caching layers in system design.

## Core Data Structures

- **String** — Cache values, counters, rate limiting
- **List** — Message queues, activity feeds (LPUSH, RPOP)
- **Set** — Unique items, tags, online users
- **Sorted Set** — Leaderboards, priority queues (ZADD, ZRANGE, ZSCORE)
- **Hash** — User sessions, object fields
- **Bitmap** — Compact boolean tracking (daily active users)
- **HyperLogLog** — Approximate cardinality estimation

## Key Features

- In-memory storage (microsecond latency)
- Persistence options: RDB snapshots and AOF (append-only file)
- Pub/Sub messaging
- Lua scripting for atomic multi-step operations
- TTL (time-to-live) for automatic key expiration
- Redis Cluster for horizontal scaling

## System Design Use Cases

- **Caching** — Database query cache, API response cache
- **Session management** — Stateless auth token storage
- **Rate limiting** — Sliding window or token bucket via counters
- **Distributed locking** — Redlock algorithm
- **Leaderboards** — Real-time ranking via sorted sets
- **Real-time analytics** — Counting events, unique visitors
