# Template Method Pattern

Defines the skeleton of an algorithm in the base class, deferring some steps to subclasses. Subclasses can redefine certain steps without changing the algorithm structure.

## Intent

Extract the invariant parts of an algorithm into a base class and let subclasses provide implementations for the variable steps.

## Structure

- **AbstractClass** — Contains templateMethod() (the skeleton) and abstract primitive operations
- **ConcreteClass** — Implements the abstract primitive operations

## Hook Methods

Optional steps in the template with default (often empty) implementations that subclasses can override if needed.

## Real-World Examples

- Data mining: read → process → analyze → report (concrete classes handle each format)
- Java's AbstractList: implements most of List based on get() and size() which subclasses provide
- JUnit: setUp() → test() → tearDown() is a template method
- Spring's JdbcTemplate: connection management is the template; query is the variable part

## Interview Questions

- How does Template Method differ from Strategy?
- What is a hook method and when is it useful?
- How is Template Method used in Java's AbstractCollection?
