# Visitor Pattern

Lets you add further operations to objects without modifying them. Separates an algorithm from the object structure it operates on.

## Intent

Define new operations on elements of an object structure without changing the classes of those elements. The operation is moved to a separate Visitor class.

## Structure

- **Visitor** — Interface declaring visit() methods for each ConcreteElement type
- **ConcreteVisitor** — Implements specific operations for each element type
- **Element** — Interface declaring accept(Visitor) method
- **ConcreteElement** — Implements accept() by calling visitor.visit(this)
- **ObjectStructure** — Collection of elements; allows iterating for visitor to visit all

## Real-World Examples

- Compiler AST traversal (type checking, code generation are separate visitors)
- Tax calculation on different types of exported documents
- Java's FileVisitor (Files.walkFileTree)

## Interview Questions

- What is the "double dispatch" mechanism in Visitor?
- When does Visitor become impractical?
- How does Visitor violate or support Open/Closed Principle?
