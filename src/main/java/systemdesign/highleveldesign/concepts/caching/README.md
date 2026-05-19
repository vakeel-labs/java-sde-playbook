# Caching

Caching stores frequently accessed data in a faster storage layer (memory) to reduce latency and decrease load on databases and downstream services.

## Cache Hit vs Cache Miss

- **Cache Hit** — Data found in cache; returned immediately (microseconds)
- **Cache Miss** — Data not in cache; fetch from source (database), store in cache, return

## Caching Strategies

### Cache-Aside (Lazy Loading)
- Application checks cache first; on miss, reads DB and populates cache
- Pro: cache only stores requested data (no wasted space)
- Con: first request is always slow (cache miss)

### Write-Through
- Write to cache AND database simultaneously on every write
- Pro: cache is always up to date
- Con: write latency increases; cache may store data never read

### Write-Behind (Write-Back)
- Write to cache only; asynchronously write to database later
- Pro: very fast writes
- Con: risk of data loss if cache node fails before DB write

### Read-Through
- Cache automatically loads data from DB on cache miss (transparent to app)

## Cache Eviction Policies

- **LRU** (Least Recently Used) — Most common; evict the item not accessed longest
- **LFU** (Least Frequently Used) — Evict item accessed fewest times
- **FIFO** — Evict oldest inserted item
- **TTL** — Evict after a fixed time-to-live regardless of access

## Where to Cache

- **Client-side** — Browser cache, mobile app cache
- **CDN** — Cache static/dynamic content at edge nodes
- **Application-level** — In-process cache (Guava Cache, Caffeine)
- **Distributed cache** — Redis, Memcached (shared across app instances)
- **Database query cache** — MySQL query cache (deprecated in 8.0)

## Cache Challenges

- **Cache Invalidation** — How to keep cache consistent with DB (hardest problem)
- **Cache Stampede / Thundering Herd** — Many requests hit DB simultaneously after cache expires
- **Hot Key Problem** — One cache key receives disproportionate traffic

## Interview Questions

- What is the difference between Cache-Aside and Write-Through?
- How do you handle cache invalidation when the database changes?
- What is a cache stampede and how do you prevent it?
- Redis vs Memcached — when would you choose each?
