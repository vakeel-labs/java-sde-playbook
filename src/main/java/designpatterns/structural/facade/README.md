# Facade Pattern

Provides a simplified interface to a complex subsystem, library, or framework.

## Intent

Hide the complexity of a subsystem by exposing a single, simple interface. The subsystem classes still exist and can be used directly, but the facade provides a convenient shortcut.

## Structure

- **Facade** — Knows which subsystem classes handle a request; delegates client calls
- **Subsystem Classes** — Implement subsystem functionality; handle facade-delegated work
- **Client** — Uses only the Facade; unaware of subsystem complexity

## Real-World Examples

- Starting a computer: one start() call hides BIOS, boot loader, OS init, etc.
- Home theater: watchMovie() hides projector, sound system, streaming device setup
- Spring's JdbcTemplate: hides JDBC boilerplate (connection, statement, result set)
- API Gateway in microservices — facade for multiple backend services

## Interview Questions

- How does Facade differ from Adapter?
- Does Facade prevent clients from accessing subsystem classes directly?
- How is Facade used in API design and microservices?
