# Observer Pattern

Defines a one-to-many dependency so that when one object changes state, all its dependents are notified and updated automatically.

## Intent

Establish an event subscription mechanism where objects (observers) can subscribe to receive notifications from a subject when it changes state.

## Structure

- **Subject (Publisher)** — Maintains a list of observers; notifies them of changes
- **Observer (Subscriber)** — Interface with an update() method
- **ConcreteSubject** — Stores state; triggers notifications on state change
- **ConcreteObserver** — Reacts to subject's state change

## Real-World Examples

- Event listeners in Java (ActionListener, MouseListener)
- Java's java.util.Observable (deprecated) and PropertyChangeListener
- Model-View architecture (View observes Model changes)
- Stock ticker: subscribers notified of price changes
- Notification systems, pub/sub messaging

## Interview Questions

- What is the difference between Observer and Event Bus / Pub-Sub?
- What are the memory leak risks with Observer in Java?
- How does Observer relate to the reactive programming model (RxJava)?
