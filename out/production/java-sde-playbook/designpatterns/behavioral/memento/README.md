# Memento Pattern

Without violating encapsulation, captures and externalizes an object's internal state so that the object can be restored to this state later.

## Intent

Save snapshots of an object's internal state and allow restoration to previous states — enabling undo/redo functionality without exposing implementation details.

## Structure

- **Originator** — Creates a memento containing a snapshot of its current state; restores from memento
- **Memento** — Stores state of the Originator; only Originator can read/write it
- **Caretaker** — Keeps history of mementos; does not operate on or examine mementos

## Real-World Examples

- Text editor undo: each edit creates a Memento snapshot stored in an undo stack
- Game save states
- Transaction rollback (database logs are a form of memento)
- Browser navigation history (back/forward)

## Interview Questions

- How does Memento differ from Command for implementing undo?
- What are the memory implications of storing many mementos?
- How does Memento preserve encapsulation?
