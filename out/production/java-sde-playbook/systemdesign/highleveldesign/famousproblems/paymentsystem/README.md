# Payment System (Stripe / PayPal)

## Scale
Millions of transactions/day, strict financial accuracy required, 99.999% availability, global multi-currency

## Core Challenges
ACID consistency, idempotency to prevent double charges, fraud detection in real-time, regulatory compliance, reconciliation

## APIs
- POST /payments { amount, currency, source, idempotency_key, description } -> payment_id, status
- GET /payments/{payment_id} -> payment status and details
- POST /refunds { payment_id, amount? } -> refund_id
- POST /payouts { amount, destination_bank_account } -> payout_id
- GET /balance -> current available and pending balance

## Core Components
- **Payment API Service** - Validates input; enforces idempotency; publishes payment events
- **Idempotency Layer** - Redis/DB store of idempotency_key -> result; prevents duplicate processing on retries
- **Payment Processor** - Communicates with card networks (Visa/MC) and acquiring banks; handles authorization and capture
- **Double-Entry Ledger** - Append-only accounting ledger in PostgreSQL; every transaction has debit + credit entry
- **Fraud Detection Service** - Real-time ML model scores every transaction (< 50ms); rule engine for known fraud patterns
- **Notification Service** - Webhooks to merchant, email receipts to customers on payment events
- **Reconciliation Service** - Daily batch job comparing internal ledger against bank settlement files

## Deep Dive
- **Idempotency**: Client generates UUID idempotency_key for each payment attempt. Server stores (key -> response) in Redis with TTL. On retry with same key, server returns stored response without re-processing. Prevents double charges on network retries.
- **Double-entry ledger**: Every payment creates TWO immutable rows (debit from customer account, credit to merchant account). Ledger is append-only (no UPDATE or DELETE). Account balance = SUM of all entries. Audit trail is built-in.
- **Two-phase payment**: Authorize (hold funds on customer card) -> Capture (complete the charge). Authorize is instant; capture happens when merchant ships. Reduces fraud risk.
- **Exactly-once semantics**: Idempotent API (client) + at-least-once delivery (internal) + deduplication at each step = effectively exactly-once. No financial double-processing.
- **Fraud detection**: < 50ms scoring budget using lightweight ML model (gradient boosted trees). Features: transaction velocity, merchant category, geo-location, device fingerprint, historical patterns.

## Key Trade-offs
- Synchronous vs async payment: synchronous gives immediate feedback but ties up threads; async (queue-based) scales better but UX is worse (pending state)
- Fraud model: precision vs recall trade-off; false positives (blocking legitimate transactions) lose revenue; false negatives (approving fraud) lose money
- Consistency: PostgreSQL with serializable isolation for ledger; no NoSQL for financial data
