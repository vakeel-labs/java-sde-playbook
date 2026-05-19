# UML Diagrams for System Design

Visual modeling tools for communicating design decisions clearly in interviews and documentation.

## Diagram Types

### Class Diagram
- Shows classes, interfaces, their fields, methods, and relationships
- Relationships: Association, Aggregation, Composition, Inheritance, Realization
- Visibility: + public, - private, # protected

### Sequence Diagram
- Shows how objects interact over time for a specific use case
- Lifelines, messages (synchronous, asynchronous, return), activation bars
- Used to document the flow of a key use case (e.g., Place Order)

### Use Case Diagram
- Shows actors and their interactions with the system
- High-level view of what the system does (not how)

### Activity Diagram
- Flowchart for a process or algorithm
- Useful for documenting complex business logic

### ER Diagram (Entity-Relationship)
- Models database schema: entities, attributes, relationships
- Cardinality: one-to-one, one-to-many, many-to-many

## UML Relationships in Java

| UML Relationship | Java Example |
|-----------------|--------------|
| Inheritance (extends) | class Dog extends Animal |
| Realization (implements) | class Dog implements Runnable |
| Composition (has-a, lifecycle tied) | Car has Engine (engine dies with car) |
| Aggregation (has-a, independent) | Department has Employees (employees survive) |
| Association (uses) | Teacher teaches Student |
| Dependency (uses temporarily) | Method uses a parameter type |
