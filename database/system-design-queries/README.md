# System Design Database Queries

Database schemas, data models, and query patterns that come up specifically in system design interview problems. Each system design problem has unique DB requirements.

## Covered System Designs

- URL Shortener — short_url, original_url, expiry, click counts
- Twitter / Social Feed — users, tweets, follows, likes, timeline
- E-commerce (Amazon) — products, orders, inventory, reviews
- Ride Sharing (Uber) — drivers, riders, trips, locations, pricing
- Video Platform (YouTube) — videos, views, likes, comments, subscriptions
- Chat Application (WhatsApp) — messages, threads, delivery status
- Notification System — notification types, delivery channels, status tracking

## Topics Per System

- Schema design and ER diagrams
- Choice of database (SQL vs NoSQL) with justification
- Critical queries and their optimization
- Indexing strategy for the access patterns
- Scaling considerations (read replicas, sharding)

## Key Questions to Answer for Each System

1. What are the primary entities and their relationships?
2. What are the most frequent read queries?
3. What are the most frequent write patterns?
4. What database(s) would you choose and why?
5. What indexes are critical for performance?
