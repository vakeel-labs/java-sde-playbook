# Event-Driven Messaging

Asynchronous communication between microservices via events/messages. Enables loose coupling, better resilience, and the ability to handle high throughput.

## Why Event-Driven?

- Synchronous REST calls create tight temporal coupling (caller must wait)
- If the downstream service is down, the call fails immediately
- Events decouple producer from consumer in time and space

## Key Concepts

- **Event** — A record that something happened (past tense: OrderPlaced, UserRegistered)
- **Command** — A request for an action to happen (CreateOrder)
- **Message Broker** — Infrastructure that stores and routes messages (Kafka, RabbitMQ)
- **Producer** — Publishes events to the broker
- **Consumer** — Subscribes to events and reacts

## Message Brokers

| Broker | Model | Retention | Use Case |
|--------|-------|-----------|---------|
| Apache Kafka | Log-based (topic/partition) | Durable, retained | High throughput, event sourcing |
| RabbitMQ | Queue-based (AMQP) | Until consumed | Task queues, fan-out |
| AWS SQS/SNS | Managed cloud | Configurable | Simple cloud-native messaging |

## Patterns

- **Pub/Sub** — One producer, many consumers (fan-out)
- **Queue/Worker** — Task distribution, exactly one consumer processes each message
- **Event Streaming** — Kafka; consumers can replay events from any offset

## Interview Questions

- What is the difference between a message queue and an event stream?
- How does Kafka achieve high throughput?
- What is at-least-once vs exactly-once delivery and how do you handle duplicates?
- What is the outbox pattern for reliable event publishing?
