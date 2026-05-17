# Composite Pattern

Lets you compose objects into tree structures to represent part-whole hierarchies. Clients treat individual objects and compositions of objects uniformly.

## Intent

Work with tree structures of objects. Component, Leaf, and Composite all share the same interface, so clients do not need to know whether they are dealing with a single object or a whole tree.

## Structure

- **Component** — Common interface for simple and complex objects
- **Leaf** — Basic element with no children; does actual work
- **Composite** — Container that holds children (Leaf or Composite); delegates work to children

## Real-World Examples

- File system: files (Leaf) and folders (Composite) — both support getSize(), list()
- UI component tree: Button (Leaf) inside Panel inside Frame
- HTML DOM: text nodes (Leaf) inside element nodes (Composite)
- Java AWT/Swing component hierarchy

## Interview Questions

- What problem does Composite solve?
- What is the trade-off of Composite (transparency vs safety)?
- When would a tree structure NOT benefit from Composite?
