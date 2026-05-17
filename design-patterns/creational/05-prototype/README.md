# Prototype Pattern

Specifies the kinds of objects to create using a prototypical instance, and creates new objects by copying (cloning) this prototype.

## Intent

Create new objects by cloning an existing object (the prototype) when object creation is expensive or when you want to avoid subclasses of an object creator.

## Key Concepts

- **Shallow copy** — Copies primitive fields; references point to same objects
- **Deep copy** — Recursively copies all referenced objects
- Java Cloneable interface and clone() method
- Copy constructor as an alternative

## Real-World Examples

- Game: clone() an enemy object to spawn multiple enemies without re-initializing
- Document editor: duplicate a complex document with all its formatting
- Spring beans with prototype scope

## Interview Questions

- What is the difference between shallow copy and deep copy?
- What are the drawbacks of Java's Cloneable interface?
- When would you use Prototype instead of just calling the constructor?
