# Message Queues

Message queues enable asynchronous communication between services, decoupling producers from consumers and providing buffering for traffic spikes.

## Why Message Queues?

- **Decoupling** — Producer does not need to know about consumers
- **Async processing** — Producer can continue without waiting for consumer
- **Load leveling** — Queue absorbs traffic spikes; consumer processes at its own pace
- **Reliability** — Messages are persisted until successfully processed
- **Fan-out** — One message can be consumed by multiple services

## Core Concepts

- **Producer** — Sends messages to the queue
- **Queue / Topic** — Stores messages
- **Consumer** — Reads and processes messages
- **Message Broker** — The server managing queues (Kafka, RabbitMQ, SQS)
- **Acknowledgement** — Consumer confirms successful processing; broker deletes message

## Delivery Guarantees

- **At-most-once** — Message may be lost but never duplicated (fire and forget)
- **At-least-once** — Message delivered at least once; may be duplicated (must handle idempotency)
- **Exactly-once** — Most complex; guaranteed no loss and no duplication (Kafka transactions)

## Popular Message Queues

| Tool | Model | Retention | Use Case |
|------|-------|-----------|---------|
| Apache Kafka | Log/stream | Persistent, replay | High throughput, event sourcing |
| RabbitMQ | Queue (AMQP) | Until consumed | Task queues, fan-out |
| AWS SQS | Queue | Configurable | Simple decoupling on AWS |
| AWS SNS | Pub/Sub | No retention | Fan-out notifications |
| Redis Streams | Log | Configurable | Lightweight streaming |

## Interview Questions

- What is the difference between a queue and a topic?
- How does Kafka achieve high throughput?
- What is idempotency and why is it needed with at-least-once delivery?
- When would you use RabbitMQ over Kafka?
