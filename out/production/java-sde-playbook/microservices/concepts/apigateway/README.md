# API Gateway

An API Gateway is the single entry point for all client requests. It routes requests to appropriate microservices and handles cross-cutting concerns.

## Responsibilities

- **Routing** — Route requests to the correct downstream service
- **Authentication & Authorization** — Validate tokens before forwarding
- **Rate Limiting** — Throttle clients to prevent abuse
- **Load Balancing** — Distribute requests across service instances
- **SSL Termination** — Handle HTTPS at the gateway, forward HTTP internally
- **Request/Response Transformation** — Modify headers, aggregate responses
- **Caching** — Cache responses for frequent identical requests
- **Circuit Breaking** — Stop forwarding to unhealthy services
- **Logging & Tracing** — Centralized access logs, correlation IDs

## Popular API Gateways

- **Spring Cloud Gateway** — Reactive, built on Spring WebFlux
- **Kong** — High-performance, plugin-based
- **AWS API Gateway** — Fully managed, serverless
- **NGINX** — Lightweight, high performance
- **Zuul** (Netflix) — Older Spring Cloud gateway (mostly replaced by Spring Cloud Gateway)

## API Gateway vs Load Balancer

- Load Balancer: distributes traffic; protocol-agnostic
- API Gateway: application-layer; understands HTTP/REST; adds business logic

## Interview Questions

- What is the difference between API Gateway and Load Balancer?
- What cross-cutting concerns does an API Gateway handle?
- What are the drawbacks of using an API Gateway? (single point of failure, latency)
