# State Pattern

Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

## Intent

Encapsulate state-specific behavior in separate state classes. The context delegates behavior to the current state object, and transitions to other state objects as needed.

## Structure

- **Context** — Maintains a reference to the current state; delegates behavior to it
- **State** — Interface for encapsulating behavior associated with a state
- **ConcreteState** — Implements behavior for a specific state

## Real-World Examples

- Traffic light: Red → Green → Yellow → Red (each color is a state)
- Order management: Pending → Confirmed → Shipped → Delivered → Cancelled
- Vending machine: Idle → HasMoney → Dispensing → OutOfStock
- TCP connection: Closed → Listen → Established → TimeWait

## Interview Questions

- How does State differ from Strategy?
- How does State eliminate long if-else chains for state management?
- How would you implement undo with State?
