# Adapter Pattern

Allows objects with incompatible interfaces to collaborate. Wraps an existing class with a new interface so it can work where a different interface is expected.

## Intent

Convert the interface of a class into another interface that clients expect. Adapter lets classes work together that could not otherwise because of incompatible interfaces.

## Types

- **Object Adapter** — Composition (holds a reference to the adaptee) — preferred
- **Class Adapter** — Multiple inheritance (Java supports via interfaces)

## Real-World Examples

- Legacy code integration: wrapping an old XML-based service to expose a JSON interface
- Java I/O: InputStreamReader adapts InputStream to Reader interface
- Arrays.asList() adapts arrays to List interface

## Interview Questions

- What is the difference between Adapter and Facade?
- When would you use object adapter over class adapter?
- How does Adapter support the Open/Closed Principle?
