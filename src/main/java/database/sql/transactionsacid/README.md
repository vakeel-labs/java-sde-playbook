# SQL Transactions & ACID

Transactions group multiple SQL operations into a single atomic unit. ACID guarantees are what make relational databases reliable for financial and business-critical systems.

## ACID Properties

- **Atomicity** — All operations succeed or all are rolled back
- **Consistency** — Database moves from one valid state to another
- **Isolation** — Concurrent transactions do not interfere with each other
- **Durability** — Committed transactions survive system failures

## Transaction Commands

- BEGIN / START TRANSACTION
- COMMIT — Persist changes permanently
- ROLLBACK — Undo all changes since BEGIN
- SAVEPOINT / ROLLBACK TO SAVEPOINT — Partial rollbacks

## Isolation Levels (from weakest to strongest)

| Level | Dirty Read | Non-Repeatable Read | Phantom Read |
|-------|-----------|---------------------|--------------|
| READ UNCOMMITTED | Possible | Possible | Possible |
| READ COMMITTED | Not Possible | Possible | Possible |
| REPEATABLE READ | Not Possible | Not Possible | Possible |
| SERIALIZABLE | Not Possible | Not Possible | Not Possible |

## Concurrency Problems

- **Dirty Read** — Reading uncommitted data from another transaction
- **Non-Repeatable Read** — Same row returns different values in same transaction
- **Phantom Read** — New rows appear in repeated range queries
- **Lost Update** — Two transactions overwrite each other's changes
- **Deadlock** — Two transactions wait for each other's locks indefinitely

## Interview Questions

- Explain ACID and give a real-world example of each property
- What isolation level does MySQL use by default?
- How do databases detect and resolve deadlocks?
