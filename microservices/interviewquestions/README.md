# Microservices Interview Questions

Curated interview questions covering microservices architecture, patterns, and implementation — from conceptual to design-level.

## Foundational Questions

1. What is microservices architecture and how does it differ from monolithic?
2. What are the advantages and disadvantages of microservices?
3. How do microservices communicate with each other?
4. What is the difference between synchronous and asynchronous communication?
5. What does "each microservice owns its database" mean and why?

## Architecture & Patterns

6. What is an API Gateway and what does it do?
7. Explain the Circuit Breaker pattern. What are its three states?
8. What is Service Discovery? Explain client-side vs server-side discovery.
9. What is the Saga pattern? Choreography vs Orchestration?
10. What is the difference between CQRS and Event Sourcing?
11. What is the Strangler Fig pattern for migrating a monolith?
12. How would you implement distributed transactions without 2PC?

## Observability & Reliability

13. What is distributed tracing? How does a Trace ID propagate?
14. What is the difference between metrics, logs, and traces?
15. How do you do health checks in microservices?
16. How would you debug a slow API request across 5 microservices?

## Data & Events

17. What is the Outbox Pattern and why is it needed?
18. How do you ensure exactly-once processing with Kafka?
19. What is eventual consistency and how do you handle it in your UI?

## Security

20. How do you implement service-to-service authentication?
21. What is the difference between OAuth2 and JWT?
22. How does an API Gateway handle authentication?

## Deployment & Scaling

23. What is a Blue-Green deployment?
24. What is a Canary deployment?
25. How does Kubernetes handle zero-downtime deployments?
