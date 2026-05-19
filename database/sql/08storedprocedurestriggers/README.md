# Stored Procedures & Triggers

Reusable server-side SQL logic. Stored procedures encapsulate business logic in the database; triggers automate reactions to data changes.

## Stored Procedures

- Creating and executing stored procedures
- Input and output parameters
- Variables and control flow (IF, WHILE, LOOP)
- Error handling with TRY/CATCH or DECLARE EXIT HANDLER
- Advantages: reduced network round-trips, centralized logic, security

## Functions vs Stored Procedures

- Functions return a value; procedures may or may not
- Functions can be used in SELECT; procedures cannot
- Procedures can have side effects (DML); functions generally cannot

## Triggers

- BEFORE INSERT / UPDATE / DELETE
- AFTER INSERT / UPDATE / DELETE
- INSTEAD OF triggers (mainly in views)
- Accessing OLD and NEW row values
- Use cases: audit logging, auto-updating derived columns, enforcing complex constraints

## When NOT to Use Stored Procedures

- Business logic belongs in the application layer (testability, version control)
- Complex multi-database logic
- When portability across DB engines matters
