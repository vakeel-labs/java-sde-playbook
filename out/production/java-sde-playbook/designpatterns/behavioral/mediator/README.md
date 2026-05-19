# Mediator Pattern

Reduces chaotic dependencies between objects by restricting direct communications and forcing them to collaborate only via a mediator object.

## Intent

Define an object (mediator) that encapsulates how a set of objects interact. Promotes loose coupling by keeping objects from referring to each other explicitly.

## Real-World Examples

- Air traffic control tower: planes don't communicate directly; all go through the tower
- Chat room: users don't send messages directly; all go through the ChatRoom mediator
- UI form: when a checkbox is changed, the mediator updates related fields
- Spring's ApplicationEventPublisher as a mediator between components

## Interview Questions

- How does Mediator differ from Observer?
- What is the risk of making a mediator too complex (God Object)?
- How is Mediator used in message broker systems like Kafka?
