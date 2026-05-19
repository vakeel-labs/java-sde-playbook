# Proxy Pattern

Provides a surrogate or placeholder for another object to control access to it.

## Intent

Create a substitute object that controls access to the real object. Allows adding behavior (logging, caching, access control, lazy initialization) without changing the real object.

## Types of Proxies

- **Virtual Proxy** — Lazy initialization; creates expensive object only when needed
- **Protection Proxy** — Controls access based on permissions
- **Remote Proxy** — Represents an object in a different address space (RMI, gRPC stub)
- **Caching Proxy** — Caches results of expensive operations
- **Logging Proxy** — Logs requests to the real object
- **Smart Reference** — Adds cleanup or reference counting

## Real-World Examples

- Hibernate lazy loading (proxy replaces entity until data is needed)
- Java RMI remote proxy
- Spring AOP proxy (adds transaction management, logging transparently)
- CDN as a caching proxy for origin servers

## Interview Questions

- How does Proxy differ from Decorator?
- How does Spring use Proxy internally for AOP?
- What is a dynamic proxy in Java? (java.lang.reflect.Proxy)
