# Vending Machine

Design a vending machine that dispenses products when correct payment is inserted.

## Functional Requirements
- Machine has multiple slots, each holding a specific product with limited quantity
- User selects a product and sees its price
- User inserts coins/notes; machine tracks the running total
- On sufficient payment, machine dispenses the product and returns change
- Machine handles: no product selected, insufficient funds, out of stock, exact change only mode

## Core Entities
- VendingMachine (Singleton)
- Product
- Slot / Inventory
- Coin / Note (denomination)
- VendingMachineState (Idle, ProductSelected, HasMoney, Dispensing, ChangePending)
- ChangeDispenser

## Design Patterns Applied
- **State**: Machine behavior completely changes with each state
- **Singleton**: One VendingMachine instance
- **Strategy**: Different change-making strategies (greedy, exact)
- **Command**: User actions (select product, insert coin, cancel) as commands
