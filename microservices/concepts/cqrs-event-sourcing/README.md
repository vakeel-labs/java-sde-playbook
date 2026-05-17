# CQRS & Event Sourcing

Two powerful patterns often used together in microservices to handle complex read/write workloads and provide a complete audit trail of state changes.

## CQRS (Command Query Responsibility Segregation)

Separate the models used for reading data (Query) from the models used for writing data (Command).

- **Command side** — Handles writes (create, update, delete); optimized for consistency
- **Query side** — Handles reads; optimized for performance (denormalized, cached)
- Commands and Queries use different models, often different databases

### Why CQRS?
- Read and write workloads scale independently
- Queries can use denormalized views without impacting write performance
- Enables different data stores for reads vs writes (e.g., SQL for writes, Elasticsearch for reads)

## Event Sourcing

Instead of storing the current state, store the sequence of events that led to the current state.

- Each state change is stored as an immutable event
- Current state is derived by replaying all events from the beginning
- Events are the source of truth

### Benefits
- Complete audit log of every change
- Ability to replay events to reconstruct past states or build new projections
- Natural fit with CQRS (events update read-side projections)

### Challenges
- Event schema evolution is hard (events must be immutable)
- Querying current state requires replaying or maintaining projections
- Eventually consistent read models

## Tools

- Axon Framework (Java) — purpose-built for CQRS + Event Sourcing
- Apache Kafka — event log storage
- EventStore — dedicated event sourcing database

## Interview Questions

- What problem does CQRS solve that a single model cannot?
- How does Event Sourcing differ from traditional database state storage?
- How do you handle schema changes in an event sourcing system?
