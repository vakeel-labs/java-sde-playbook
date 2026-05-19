# Elevator System

Design an elevator control system for a building with multiple elevators and floors.

## Functional Requirements
- N elevators serving M floors
- Users press up/down buttons on each floor
- Inside elevator, user presses destination floor button
- Elevator algorithm minimizes wait time (SCAN/LOOK algorithm)
- Elevator can be in state: IDLE, MOVING_UP, MOVING_DOWN, MAINTENANCE

## Core Entities
- ElevatorSystem (Singleton/Facade)
- Elevator
- ElevatorButton (inside elevator)
- HallButton (on each floor — up/down)
- ElevatorState (Idle, MovingUp, MovingDown, Maintenance)
- ElevatorController / Dispatcher
- Request (ExternalRequest from hall, InternalRequest from inside)

## Design Patterns Applied
- **State**: Elevator behavior changes based on current state
- **Strategy**: Different scheduling algorithms (FCFS, SCAN, LOOK)
- **Observer**: Buttons observe elevator state changes
- **Singleton**: ElevatorSystem as central controller
