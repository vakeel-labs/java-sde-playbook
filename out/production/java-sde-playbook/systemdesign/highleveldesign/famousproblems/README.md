# HLD Famous System Design Problems

Classic system design problems asked in top tech company interviews (FAANG and beyond). Each problem covers the full architecture from requirements to deep-dive on critical components.

## Problems

| Problem | Core Challenges | Difficulty |
|---------|----------------|-----------|
| [URL Shortener](./url-shortener) | ID generation, redirection, analytics | Easy |
| [Twitter Design](./twitter-design) | Feed generation (push vs pull), scalability | Hard |
| [YouTube Design](./youtube-design) | Video upload/encoding, streaming, CDN | Hard |
| [WhatsApp Design](./whatsapp-design) | Real-time messaging, delivery receipts | Hard |
| [Uber Design](./uber-design) | Geo-matching, real-time tracking, pricing | Hard |
| [Instagram Design](./instagram-design) | Photo storage, feed, social graph | Medium |
| [Amazon Design](./amazon-design) | Product catalog, inventory, ordering | Hard |
| [Google Drive Design](./google-drive-design) | File storage, sync, collaboration | Medium |
| [Netflix Design](./netflix-design) | Video streaming, CDN, recommendation | Hard |
| [Google Search Design](./google-search-design) | Web crawling, indexing, ranking | Very Hard |
| [Payment System](./payment-system) | Consistency, idempotency, fraud detection | Hard |
| [Notification System](./notification-system) | Multi-channel delivery, priority, scale | Medium |
| [Web Crawler](./web-crawler) | Distributed crawling, deduplication, politeness | Medium |

## Universal Design Template

For every problem, answer these questions:
1. **Requirements** — Functional + Non-functional (scale, latency, availability)
2. **Capacity Estimate** — DAU, QPS, storage
3. **APIs** — Define the key API endpoints
4. **Data Model** — Schema, DB choice
5. **High-Level Architecture** — Components and how they connect
6. **Deep Dive** — Critical component in detail
7. **Bottlenecks & Scale** — How to handle 10x or 100x growth
