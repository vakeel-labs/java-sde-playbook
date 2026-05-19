# Chain of Responsibility Pattern

Passes a request along a chain of handlers. Each handler decides to process the request or pass it to the next handler in the chain.

## Intent

Decouple senders and receivers of requests by giving multiple objects a chance to handle the request. Chain the receiving objects and pass the request along the chain.

## Structure

- **Handler** — Interface with handle(request) and a reference to the next handler
- **ConcreteHandler** — Handles requests it is responsible for; passes others to next handler
- **Client** — Composes the chain and initiates the request

## Real-World Examples

- HTTP middleware pipeline (authentication → logging → rate limiting → route handler)
- Java exception handling (try/catch chain)
- Event bubbling in UI frameworks (child → parent → root)
- Support ticket escalation (Level 1 → Level 2 → Manager)
- Java Servlet Filters

## Interview Questions

- What happens if no handler processes the request?
- How does Chain of Responsibility differ from Decorator?
- How is CoR used in Spring Security's filter chain?
