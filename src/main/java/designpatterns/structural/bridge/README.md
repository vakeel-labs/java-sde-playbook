# Bridge Pattern

Decouples an abstraction from its implementation so that the two can vary independently.

## Intent

Split a large class or a set of closely related classes into two separate hierarchies — abstraction and implementation — which can be developed independently.

## Structure

- **Abstraction** — High-level control layer, delegates implementation work
- **RefinedAbstraction** — Extends Abstraction with more specific behavior
- **Implementation** — Interface for implementation classes
- **ConcreteImplementation** — Platform-specific implementations

## Real-World Examples

- Remote controls (Abstraction) and devices (Implementation) — TV remote, Radio remote, both work with TV or Radio
- Drawing shapes (Circle, Square) on different rendering APIs (OpenGL, DirectX)
- Logging abstraction (Logger) with different backends (File, Database, Console)

## Interview Questions

- How does Bridge differ from Adapter?
- When would you use Bridge over Strategy?
- Bridge vs Composition — what is the difference?
