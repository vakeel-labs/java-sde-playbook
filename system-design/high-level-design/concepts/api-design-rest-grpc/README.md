# API Design — REST & gRPC

Designing clear, consistent, and scalable APIs is a core skill for system design. REST and gRPC are the two dominant paradigms for service communication.

## REST (Representational State Transfer)

### Principles
- **Stateless** — Server stores no client session state
- **Resource-based** — URLs represent resources (nouns), not actions (verbs)
- **HTTP methods** — GET (read), POST (create), PUT/PATCH (update), DELETE (delete)
- **Uniform interface** — Consistent conventions across endpoints
- **Cacheable** — Responses indicate cache headers

### REST Best Practices
- Use nouns for resources: /users, /orders/{id}
- Use proper HTTP status codes: 200, 201, 204, 400, 401, 403, 404, 409, 429, 500
- Version APIs: /api/v1/users
- Use pagination: ?page=1&limit=20 or cursor-based
- Use filtering, sorting, field selection: ?status=active&sort=created_at&fields=id,name

### REST Limitations
- Over-fetching (getting too much data) and under-fetching (needing multiple calls)
- No strict contract/schema (OpenAPI/Swagger helps)
- HTTP/1.1 text-based overhead

## gRPC

### What is gRPC?
- Google's open-source RPC framework
- Uses Protocol Buffers (protobuf) for serialization — compact binary format
- HTTP/2 for transport — multiplexed streams, header compression

### gRPC vs REST

| | REST | gRPC |
|-|------|------|
| Protocol | HTTP/1.1 (text) | HTTP/2 (binary) |
| Payload | JSON | Protocol Buffers |
| Contract | Optional (OpenAPI) | Required (.proto file) |
| Streaming | Limited | Native (client, server, bidirectional) |
| Browser support | Excellent | Limited (needs proxy) |
| Performance | Good | 5-10x faster than JSON REST |

### When to Use gRPC
- Internal service-to-service communication (microservices)
- High-performance, low-latency requirements
- Streaming use cases (real-time data)
- Strict API contract enforcement

## Interview Questions

- What is the difference between PUT and PATCH?
- How do you handle API versioning?
- When would you use gRPC over REST?
- What is idempotency and which HTTP methods should be idempotent?
