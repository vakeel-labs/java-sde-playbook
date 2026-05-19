# Rate Limiting

Rate limiting controls the rate of requests a client can make to an API, protecting services from abuse, DoS attacks, and overload.

## Why Rate Limiting?

- Prevent DoS / DDoS attacks
- Ensure fair usage among clients
- Protect backend services from overload
- Enforce business limits (free vs paid tier limits)

## Rate Limiting Algorithms

### Fixed Window Counter
- Count requests in a fixed time window (e.g., 100 req/minute)
- Reset counter at window boundary
- Problem: burst at window edges (200 req in 2 seconds across boundary)

### Sliding Window Log
- Store timestamp of each request; count requests in the last N seconds
- No boundary burst problem
- Con: high memory usage (store every request timestamp)

### Sliding Window Counter
- Hybrid of fixed window and sliding window log
- Use weighted count from previous window + current window count
- Memory efficient, approximation of true sliding window

### Token Bucket
- Bucket holds tokens (capacity = max burst size)
- Tokens added at a fixed rate (refill rate)
- Each request consumes one token; if empty → reject
- Allows bursts up to bucket capacity; smooth average rate
- Used by AWS, Stripe

### Leaky Bucket
- Requests fill a queue (bucket); processed at a fixed rate (leak rate)
- Smooths out bursts — no matter how fast requests come, output is steady
- Good for smoothing traffic but queue can grow under sustained load

## Where to Implement

- **API Gateway** — Centralized; all traffic passes through
- **Application layer** — Per-service; more flexible
- **Reverse proxy** — NGINX, Envoy support rate limiting

## Storage for Rate Limiting State

- **Redis** — Distributed counter with TTL; supports atomic increment
- Single Redis instance handles all app instances

## Interview Questions

- What is the difference between Token Bucket and Leaky Bucket?
- How do you implement distributed rate limiting across multiple servers?
- How do you rate limit by user, IP, or API key?
