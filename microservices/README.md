# Microservices

End-to-end coverage of microservices architecture — from design principles to implementation with Spring Boot/Cloud, containerization with Docker, and orchestration with Kubernetes.

## Contents

| Folder | Description |
|--------|-------------|
| [concepts](./concepts) | Core microservices patterns and principles |
| [spring-boot](./spring-boot) | Building microservices with Spring Boot |
| [spring-cloud](./spring-cloud) | Distributed systems tools for Spring (Eureka, Gateway, Config) |
| [docker](./docker) | Containerizing microservices |
| [kubernetes](./kubernetes) | Orchestrating containers at scale |
| [interview-questions](./interview-questions) | Microservices interview Q&A |

## What is Microservices Architecture?

An architectural style that structures an application as a collection of small, autonomous services modeled around a business domain — each independently deployable, scalable, and maintainable.

## Core Principles

- Single Responsibility (one service, one business capability)
- Decentralized data management (each service owns its database)
- Communicate via APIs (REST, gRPC) or events (Kafka, RabbitMQ)
- Failure isolation (a failing service should not bring down the system)
- Independent deployability
