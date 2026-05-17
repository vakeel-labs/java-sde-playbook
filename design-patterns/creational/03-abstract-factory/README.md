# Abstract Factory Pattern

Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

## Intent

Create families of objects that belong together, without being tied to specific implementations. Ensures compatibility among created objects.

## Structure

- **AbstractFactory** — Interface declaring creation methods for each product
- **ConcreteFactory** — Implements creation methods for a specific product family
- **AbstractProduct** — Interface for a type of product
- **ConcreteProduct** — Specific product implementation

## Difference from Factory Method

| | Factory Method | Abstract Factory |
|-|----------------|-----------------|
| Scope | Single product | Family of products |
| Mechanism | Inheritance (subclass) | Composition (object) |

## Real-World Examples

- Cross-platform UI toolkit (WindowsFactory vs MacFactory, each creates Button, Checkbox, etc.)
- Database drivers (MySQLFactory vs PostgreSQLFactory — creates Connection, Command, DataReader)
- Java: javax.xml.parsers.DocumentBuilderFactory

## Interview Questions

- When would you choose Abstract Factory over Factory Method?
- How does Abstract Factory enforce product family consistency?
