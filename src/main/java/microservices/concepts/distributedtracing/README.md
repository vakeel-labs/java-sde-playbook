# Distributed Tracing

When a single user request spans multiple microservices, distributed tracing provides end-to-end visibility into the request journey, latencies, and failures.

## The Problem

A request to the API gateway may call 5+ services. If it's slow or fails, which service is responsible? Logs from individual services do not help without correlation.

## Core Concepts

- **Trace** — The end-to-end journey of a single request across all services
- **Span** — A single unit of work within a trace (one service's processing)
- **Trace ID** — A unique ID shared by all spans in the same trace (propagated in headers)
- **Span ID** — Unique ID for a single span
- **Parent Span ID** — Links child spans to their parent

## How It Works

1. The first service generates a Trace ID and Span ID and injects them into headers
2. Each downstream service extracts the Trace ID, creates a new Span ID, and forwards both
3. All spans are collected and assembled into a trace tree
4. A tracing backend stores and visualizes the trace

## Tools

- **Zipkin** (Twitter) — Open source; simple UI; integrates with Spring Cloud Sleuth
- **Jaeger** (Uber) — OpenTracing compatible; Kubernetes-native
- **OpenTelemetry** — Vendor-neutral standard for traces, metrics, and logs
- **Spring Cloud Sleuth** — Adds trace/span IDs automatically in Spring Boot

## Interview Questions

- What is the difference between logging and distributed tracing?
- How does a Trace ID propagate across service boundaries?
- What is OpenTelemetry and why is it important?
