# Circuit Breaker Pattern

Prevents cascading failures in a microservices system. When a service is failing, the circuit breaker trips and fails fast rather than waiting for timeouts.

## The Problem

If Service A calls Service B which is slow or down, Service A's threads pile up waiting for responses → Service A becomes slow too → callers of A also wait → cascading failure.

## Circuit Breaker States

- **CLOSED** — Normal operation; calls pass through; failures are counted
- **OPEN** — Threshold exceeded; calls fail immediately (fail fast) without calling the service
- **HALF_OPEN** — After a timeout, test calls are allowed through to check if the service recovered

## Configuration Parameters

- Failure rate threshold (e.g., 50% of last N calls fail → trip to OPEN)
- Slow call rate threshold
- Wait duration in OPEN state before moving to HALF_OPEN
- Number of permitted calls in HALF_OPEN state

## Fallback Strategy

When the circuit is OPEN, return:
- Cached data from previous successful calls
- A default/empty response
- An error message from a fallback method

## Implementations

- **Resilience4j** — Lightweight, functional, recommended for Spring Boot
- **Hystrix** (Netflix) — Deprecated but still widely referenced
- **Spring Cloud Circuit Breaker** — Abstraction over Resilience4j or Hystrix

## Interview Questions

- What are the three states of a circuit breaker and their transitions?
- How is Circuit Breaker different from a timeout?
- What is a fallback and when should it be used?
