# ATM System

Design an ATM system that allows users to withdraw cash, deposit, check balance, and transfer funds.

## Functional Requirements
- User inserts card → enters PIN → authenticated
- Operations: Withdraw, Deposit, Check Balance, Transfer, Mini Statement
- System communicates with the bank's backend for validation
- Machine dispenses cash (bill denominations: 100, 200, 500)
- Session timeout after inactivity
- Card blocked after 3 wrong PINs

## Core Entities
- ATM (Singleton per machine)
- ATMState (NoCard, HasCard, Authenticated, Dispensing)
- Card
- Account
- BankService (interface to bank backend)
- Transaction
- CashDispenser
- Screen, Keypad, CardReader (hardware abstractions)

## Design Patterns Applied
- **State**: ATM behavior depends entirely on current state
- **Command**: Each transaction (withdraw, deposit) is a Command with undo capability
- **Strategy**: Cash dispensing algorithm (minimize bills)
- **Singleton**: ATM instance
- **Facade**: ATM facade hides bank backend complexity from the UI
