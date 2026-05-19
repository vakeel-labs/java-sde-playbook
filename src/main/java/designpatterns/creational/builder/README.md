# Builder Pattern

Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## Intent

Construct complex objects step by step. Especially useful when an object has many optional parameters or requires a specific construction sequence.

## Structure

- **Builder** — Interface declaring construction steps
- **ConcreteBuilder** — Implements steps; keeps track of the product under construction
- **Director** — Controls the construction sequence (optional)
- **Product** — The complex object being built

## Java Builder Idiom (Effective Java)

The inner static Builder class pattern (no separate Director) is the most common form in Java:
```
Person person = new Person.Builder("John")
    .age(30)
    .email("john@example.com")
    .build();
```

## Real-World Examples

- Building SQL queries (QueryBuilder)
- HTTP request builders (OkHttp RequestBuilder)
- StringBuilder / StringBuffer in Java
- Lombok @Builder annotation

## Interview Questions

- What problem does Builder solve that telescoping constructors cannot?
- How does Builder differ from the Abstract Factory?
- When is the Director class useful and when can it be omitted?
