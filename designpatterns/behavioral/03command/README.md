# Command Pattern

Encapsulates a request as an object, allowing parameterization of clients with different requests, queuing of requests, and support for undoable operations.

## Intent

Turn a request into a stand-alone object containing all information about the request. This lets you pass requests as method arguments, delay or queue execution, and support undo.

## Structure

- **Command** — Interface with execute() method
- **ConcreteCommand** — Implements execute(); stores receiver and parameters
- **Receiver** — Object that performs the actual work
- **Invoker** — Triggers command execution; may queue commands
- **Client** — Creates ConcreteCommand and sets its receiver

## Real-World Examples

- Text editor: each user action (type, delete, format) is a Command → enables undo/redo
- Transaction management: database operations wrapped as commands
- Remote controls: each button is a Command
- Thread pool: submit tasks as Command objects (java.lang.Runnable is Command)

## Interview Questions

- How does Command support undo/redo functionality?
- How does java.lang.Runnable relate to the Command pattern?
- What is the difference between Command and Strategy?
