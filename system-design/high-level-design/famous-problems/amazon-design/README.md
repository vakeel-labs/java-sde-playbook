# Amazon E-commerce Platform

## Scale
300M customers, Prime Day peak of 60K orders/minute, millions of products, global warehouses and fulfillment centers

## Core Challenges
Inventory consistency under high concurrency, order management with Saga, product search at scale, recommendation engine

## APIs
- GET /products/search?q=keyword&filters -> ranked product list
- GET /products/{id} -> product detail with real-time inventory status
- POST /cart/items { product_id, quantity }
- POST /orders -> place order (from cart contents)
- GET /orders/{id} -> order status + tracking info

## Core Components
- **Product Catalog Service** - Product data in DynamoDB; full-text search via Elasticsearch
- **Inventory Service** - Stock per product per warehouse; PostgreSQL with optimistic locking for reservation
- **Cart Service** - Session cart in Redis; persistent cart in DynamoDB for logged-in users
- **Order Service** - Creates and manages orders; orchestrates saga across inventory, payment, fulfillment
- **Payment Service** - Integrates with payment gateways; idempotent payment processing
- **Fulfillment Service** - Routes to optimal warehouse; generates shipping label; tracks package
- **Recommendation Service** - "Customers also bought" via collaborative filtering on Apache Spark; results cached in Redis

## Deep Dive
- **Inventory reservation**: Optimistic locking with version field in PostgreSQL. UPDATE inventory SET quantity = quantity - 1, version = version + 1 WHERE product_id = ? AND quantity >= 1 AND version = ?. Retry on conflict.
- **Order saga**: Place Order -> Reserve Inventory -> Process Payment -> Notify Fulfillment. On any failure: compensating transactions run in reverse order (Release Inventory, Refund Payment).
- **Flash sale handling**: Pre-warm caches; rate limit order service with token bucket; use a queue to absorb burst; Redis atomic DECR to check/update inventory counter (fast path before DB write).
- **Search**: Elasticsearch with TF-IDF relevance scoring + business boosts (Prime eligible, review count, sponsored). Faceted filtering on price, brand, rating. Auto-complete from popular search terms.

## Key Trade-offs
- Inventory: eventual vs strong consistency. For inventory reservation, strong consistency is required (use SQL with row-level locking). For display (product page showing "In Stock"), eventual consistency is acceptable.
- Recommendation freshness: batch (daily Spark job, stale) vs real-time (Kafka stream, fresh but complex)
- Microservices DB: each service owns its database (polyglot persistence: DynamoDB for catalog, PostgreSQL for orders/inventory)
