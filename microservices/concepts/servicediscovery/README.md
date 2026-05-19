# Service Discovery

In a microservices architecture, service instances are created and destroyed dynamically. Service discovery allows services to find each other without hardcoded addresses.

## Problem

Services need to call each other, but IP addresses and ports change dynamically (containers, scaling, restarts). Hardcoding is not an option.

## Types of Service Discovery

### Client-Side Discovery
- Client queries a Service Registry (Eureka, Consul, Zookeeper)
- Client selects an instance and makes the call directly
- Load balancing logic lives in the client
- Example: Netflix Eureka + Ribbon

### Server-Side Discovery
- Client calls a Load Balancer or API Gateway
- Load Balancer queries the registry and routes the request
- Client is unaware of the registry
- Example: AWS ALB, Kubernetes Service

## Service Registry

- **Eureka** (Netflix/Spring Cloud) — AP (eventually consistent)
- **Consul** (HashiCorp) — CP (consistent), also provides KV store and health checks
- **Zookeeper** (Apache) — CP, low-level, complex
- **Kubernetes Service** — built-in DNS-based discovery

## Interview Questions

- What is the difference between client-side and server-side discovery?
- How does Kubernetes handle service discovery without a separate registry?
- What happens when a service instance goes down — how does the registry know?
