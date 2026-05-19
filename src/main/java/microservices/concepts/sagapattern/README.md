# Saga Pattern

The Saga pattern manages distributed transactions across multiple microservices — each with their own database — without using a two-phase commit (2PC).

## The Problem

A business transaction (e.g., Place Order) spans multiple services (Order, Payment, Inventory). If one step fails, all preceding steps must be undone. 2PC is too slow and locks resources.

## Saga Types

### Choreography-Based Saga
- Each service listens for events and publishes events after completing its step
- No central coordinator
- Pro: simple, decoupled
- Con: hard to track overall transaction; risk of cyclic dependencies

### Orchestration-Based Saga
- A central Saga Orchestrator sends commands to each service and waits for replies
- Orchestrator manages the flow and compensating transactions on failure
- Pro: centralized flow visibility, easier debugging
- Con: orchestrator can become a single point of complexity

## Compensating Transactions

The "undo" for each step if a later step fails:
- Place Order → if Payment fails → Cancel Order (compensating transaction)
- Reserve Inventory → if Shipping fails → Release Inventory (compensating transaction)

## Tools

- Spring State Machine
- Temporal.io
- Axon Framework (supports Saga orchestration natively)

## Interview Questions

- Why can't you use a database transaction across microservices?
- What is a compensating transaction?
- What is the difference between choreography and orchestration saga?
