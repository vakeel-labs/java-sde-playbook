# Docker for Microservices

Docker containers package microservices with all their dependencies — enabling consistent environments from development to production.

## Core Concepts

- **Image** — Immutable blueprint for a container (built from a Dockerfile)
- **Container** — Running instance of an image
- **Dockerfile** — Instructions to build an image
- **Docker Hub** — Public registry for images
- **Volume** — Persistent storage that outlives a container
- **Network** — Isolated network for containers to communicate

## Dockerfile for Spring Boot

Key instructions:
- FROM — base image (openjdk:17-jdk-slim)
- WORKDIR — set working directory
- COPY — copy files into image
- RUN — execute commands during build
- EXPOSE — declare port (documentation only)
- CMD / ENTRYPOINT — command to run when container starts

## Multi-Stage Builds

Build in one stage (with Maven/Gradle), run in a smaller base image — reduces final image size significantly.

## Docker Compose

Run multiple services locally with a single docker-compose.yml:
- Define services, networks, and volumes
- Environment variable injection
- Health checks and dependency ordering (depends_on)

## Essential Docker Commands

- docker build -t image-name .
- docker run -p 8080:8080 image-name
- docker ps, docker logs, docker exec -it, docker stop
- docker-compose up -d, docker-compose down

## Interview Questions

- What is the difference between CMD and ENTRYPOINT?
- What is a multi-stage Docker build and why is it useful?
- How do containers communicate with each other in Docker Compose?
- What is a Docker volume and when would you use it?
