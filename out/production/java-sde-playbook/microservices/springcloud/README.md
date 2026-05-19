# Spring Cloud

Spring Cloud provides tools for building distributed systems — service discovery, configuration management, API gateway, circuit breakers, and distributed tracing.

## Core Components

| Component | Purpose |
|-----------|---------|
| Spring Cloud Eureka | Service registry and discovery |
| Spring Cloud Gateway | API Gateway (reactive, replaces Zuul) |
| Spring Cloud Config | Centralized configuration server |
| Spring Cloud LoadBalancer | Client-side load balancing (replaces Ribbon) |
| Spring Cloud Circuit Breaker | Abstraction over Resilience4j |
| Spring Cloud Sleuth | Distributed tracing with Trace/Span IDs |
| Spring Cloud Bus | Broadcast config changes via message broker |
| Spring Cloud OpenFeign | Declarative REST client |

## OpenFeign — Declarative HTTP Client

Define interfaces annotated with @FeignClient to call other services:
- Auto-integrates with Eureka for service discovery
- Auto-integrates with LoadBalancer for client-side balancing
- Supports request/response interceptors for auth headers

## Spring Cloud Config Server

- Centralized configuration for all microservices
- Backed by Git repository (config changes trigger refreshes)
- @RefreshScope to refresh beans without restart

## Resilience4j Integration

- @CircuitBreaker, @Retry, @RateLimiter, @Bulkhead annotations
- Fallback methods annotated with @CircuitBreaker(name="...", fallbackMethod="...")

## Interview Questions

- What replaced Netflix Ribbon and Zuul in Spring Cloud?
- How does Spring Cloud Config work? How do services get updated config?
- How do you implement service-to-service authentication in Spring Cloud?
