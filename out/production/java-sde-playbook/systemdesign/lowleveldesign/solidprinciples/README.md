# SOLID Principles

SOLID is an acronym for five design principles that make software designs more understandable, flexible, and maintainable. Every LLD interview assumes mastery of these.

## S — Single Responsibility Principle (SRP)

A class should have one, and only one, reason to change.

- Each class should do one thing and do it well
- Violation: a UserService that handles user logic, email sending, AND PDF generation
- Fix: separate into UserService, EmailService, ReportService

## O — Open/Closed Principle (OCP)

Software entities should be open for extension but closed for modification.

- Add new behavior by adding new code, not modifying existing code
- Violation: adding a new payment type requires modifying the if-else in PaymentProcessor
- Fix: PaymentStrategy interface; add new strategies without touching PaymentProcessor

## L — Liskov Substitution Principle (LSP)

Objects of a superclass should be replaceable with objects of its subclasses without breaking the application.

- Violation: Square extends Rectangle but overrides setWidth/setHeight breaking the area contract
- Subtypes must honor the contracts (preconditions, postconditions) of the supertype

## I — Interface Segregation Principle (ISP)

Clients should not be forced to depend on interfaces they do not use.

- Split large interfaces into smaller, more specific ones
- Violation: a fat Worker interface with work(), eat(), sleep() — robots don't eat/sleep

## D — Dependency Inversion Principle (DIP)

High-level modules should not depend on low-level modules. Both should depend on abstractions.

- Violation: OrderService directly creates MySQLOrderRepository (new MySQLOrderRepository())
- Fix: OrderService depends on OrderRepository interface; inject the concrete implementation

## SOLID + Design Patterns

SOLID principles motivate most design patterns:
- OCP motivates Strategy, Decorator, Template Method
- DIP motivates all patterns using interfaces/dependency injection
- ISP motivates splitting interfaces (seen in GoF patterns)
