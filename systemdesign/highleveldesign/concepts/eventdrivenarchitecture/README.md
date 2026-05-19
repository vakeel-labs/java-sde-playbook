# Event-Driven Architecture

An architectural style where services communicate through the production, detection, and reaction to events — enabling loose coupling, scalability, and resilience.

## Core Concepts

- **Event** — An immutable record that something happened (OrderPlaced, UserRegistered)
- **Event Producer** — Service that publishes events
- **Event Consumer** — Service that subscribes and reacts to events
- **Event Broker** — Infrastructure routing events (Kafka, RabbitMQ, EventBridge)
- **Event Schema** — Contract defining event structure (Avro, JSON Schema, Protobuf)

## Benefits

- **Loose coupling** — Producer does not know who consumes its events
- **Scalability** — Consumers scale independently; broker buffers load spikes
- **Resilience** — Consumer failures do not affect the producer
- **Extensibility** — Add new consumers without changing producers
- **Auditability** — Event log provides complete history of what happened

## Event-Driven Patterns

### Event Notification
- Service emits an event to notify others something happened
- Consumers decide what to do (or nothing)

### Event-Carried State Transfer
- Events contain all the data consumers need (denormalized payload)
- Consumers don't need to query the producer service

### Event Sourcing
- Store events as the source of truth instead of current state
- Replay events to reconstruct any past state

## Challenges

- **Eventual consistency** — Consumers may lag behind; UI must handle stale data
- **Event ordering** — Kafka guarantees order within a partition; cross-partition ordering is hard
- **Schema evolution** — Events must be backward compatible
- **Debugging** — Distributed event flows are harder to trace than synchronous calls
- **Duplicate events** — At-least-once delivery requires idempotent consumers

## Interview Questions

- What is the difference between event-driven and request-driven architecture?
- How do you ensure event ordering in Kafka?
- What is the Outbox Pattern and when is it needed?
- How do you handle duplicate event processing?
