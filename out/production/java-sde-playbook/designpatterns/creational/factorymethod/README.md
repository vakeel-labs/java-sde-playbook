# Factory Method Pattern

Defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

## Intent

Decouple object creation from usage. The creator class does not need to know the exact class of object it creates — the subclass decides.

## Structure

- **Product** — Interface or abstract class for created objects
- **ConcreteProduct** — Specific implementations of Product
- **Creator** — Declares the factory method returning a Product
- **ConcreteCreator** — Overrides factory method to return a ConcreteProduct

## Real-World Examples

- UI framework: createButton() returns WindowsButton or MacButton depending on OS
- Logistics: createTransport() returns Truck or Ship depending on type
- Java: java.util.Calendar.getInstance(), NumberFormat.getInstance()

## Interview Questions

- What is the difference between Factory Method and Abstract Factory?
- When would you use Factory Method over direct instantiation (new)?
- How does Factory Method support the Open/Closed Principle?
