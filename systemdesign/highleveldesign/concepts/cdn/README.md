# Content Delivery Network (CDN)

A CDN is a geographically distributed network of servers (edge nodes/PoPs) that cache content close to users, reducing latency for global audiences.

## How CDN Works

1. User requests content (image, video, JS file)
2. DNS routes the request to the nearest CDN edge node (Point of Presence)
3. If the edge node has the content cached → serve immediately (cache hit)
4. If not → fetch from the origin server, cache locally, then serve (cache miss)

## What CDNs Cache

- Static assets: images, CSS, JavaScript, fonts
- Video streams (YouTube, Netflix use CDN for video chunks)
- API responses (with proper Cache-Control headers)
- HTML pages (for JAMstack sites)

## CDN Benefits

- Reduced latency (serve from 50ms away vs 300ms to origin)
- Reduced origin server load (95%+ cache hit rate for popular assets)
- DDoS protection (absorb attack traffic at edge before it reaches origin)
- High availability (even if origin is down, CDN serves cached content)
- Global reach without deploying infrastructure everywhere

## CDN Caching Concepts

- TTL (Time-to-Live) — how long CDN caches content before checking origin
- Cache-Control headers — origin controls CDN caching behavior
- Cache Invalidation — force CDN to purge stale content
- Versioned URLs — /assets/app.v3.js avoids stale cache issues

## Popular CDNs

- Cloudflare, AWS CloudFront, Akamai, Fastly, Azure CDN

## Interview Questions

- How does a CDN reduce latency?
- What is cache invalidation in a CDN and how do you handle it?
- How does a CDN protect against DDoS attacks?
- When would you NOT use a CDN?
