# Decorator Pattern

Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

## Intent

Add behavior to individual objects at runtime without affecting other objects of the same class and without changing the class itself.

## Structure

- **Component** — Interface for objects that can have responsibilities added
- **ConcreteComponent** — Base object to be decorated
- **Decorator** — Wraps a Component; delegates calls while adding behavior
- **ConcreteDecorator** — Adds specific behavior before/after delegating

## Real-World Examples

- Java I/O streams: BufferedInputStream decorates FileInputStream
- Web framework middleware (logging, authentication, compression wrapping a handler)
- Coffee ordering system: Coffee + MilkDecorator + SugarDecorator

## Interview Questions

- How does Decorator differ from Inheritance for adding behavior?
- What is the difference between Decorator and Proxy?
- Can you stack multiple decorators? What are the trade-offs?
