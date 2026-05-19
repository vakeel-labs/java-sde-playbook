# Singleton Pattern

Ensures a class has only one instance and provides a global point of access to it.

## Intent

Restrict instantiation of a class to a single object. Commonly used for shared resources like configuration, logging, connection pools, and caches.

## Key Concepts

- Private constructor (prevents external instantiation)
- Static instance variable
- Static factory method (getInstance())
- Thread safety considerations

## Implementations to Study

1. **Eager initialization** — Instance created at class loading
2. **Lazy initialization** — Instance created on first access (not thread-safe)
3. **Synchronized method** — Thread-safe but slow (synchronized getInstance())
4. **Double-checked locking** — Thread-safe and performant (volatile + synchronized block)
5. **Bill Pugh / Initialization-on-demand holder** — Best practice in Java
6. **Enum Singleton** — Joshua Bloch recommended; handles serialization too

## Real-World Examples

- Database connection pool
- Application configuration manager
- Logger (java.util.logging.Logger)
- Runtime.getRuntime() in Java

## Interview Questions

- How do you make a Singleton thread-safe in Java?
- Can a Singleton be broken? (Reflection, serialization, cloning — and how to prevent it)
- What is the difference between Singleton and static class?
- Why is Enum Singleton considered the best implementation?
