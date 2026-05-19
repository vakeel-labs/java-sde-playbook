# OOPs Concepts in Java

Object-Oriented Programming is the foundation of Java. Mastering these four pillars and their application is critical for both interviews and clean code design.

## The Four Pillars

### 1. Encapsulation
- Bundling data (fields) and methods that operate on data into a single unit (class)
- Access modifiers: private, protected, public, default (package-private)
- Getter and setter pattern; when to expose vs hide state
- Benefits: data hiding, controlled access, validation in setters

### 2. Inheritance
- Extending behavior from a parent class (extends keyword)
- Single inheritance in Java (vs multiple inheritance via interfaces)
- Method overriding and the @Override annotation
- super keyword — calling parent constructor and methods
- Inheritance vs Composition — "Is-A" vs "Has-A" relationship

### 3. Polymorphism
- **Compile-time (Static)**: Method overloading — same name, different parameters
- **Runtime (Dynamic)**: Method overriding — same signature, different class
- Upcasting and downcasting; instanceof check
- Dynamic dispatch — JVM decides method at runtime

### 4. Abstraction
- Abstract classes: partial implementation, cannot be instantiated
- Interfaces: full abstraction (pre-Java 8), contract definition
- Abstract class vs Interface — when to use which
- default and static methods in interfaces (Java 8+)

## Key OOPs Topics

- Constructors (default, parameterized, copy constructor, constructor chaining)
- this and super keyword usage
- Object class methods: equals(), hashCode(), toString(), clone()
- Covariant return types
- SOLID principles (designed to solve OOPs design problems)

## Interview Questions

- What is the difference between abstract class and interface?
- Can we override static methods? Why not?
- What is the diamond problem and how does Java solve it?
- What is the difference between overloading and overriding?
- Can a constructor be private? When would you do that?
