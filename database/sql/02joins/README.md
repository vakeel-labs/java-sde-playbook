# SQL Joins

Joins combine rows from two or more tables based on a related column. Mastering joins is essential for working with normalized relational databases.

## Types of Joins

- **INNER JOIN** — Returns rows that have matching values in both tables
- **LEFT (OUTER) JOIN** — All rows from left table + matched rows from right
- **RIGHT (OUTER) JOIN** — All rows from right table + matched rows from left
- **FULL OUTER JOIN** — All rows from both tables
- **CROSS JOIN** — Cartesian product of both tables
- **SELF JOIN** — Join a table with itself (hierarchies, comparisons)

## Advanced Join Concepts

- Join on multiple conditions
- Non-equi joins (join on range conditions)
- Joining more than 2 tables
- Performance impact of join order
- Implicit join vs explicit JOIN syntax

## Common Interview Patterns

- Find employees without a manager (LEFT JOIN + NULL check)
- Find duplicate records across tables
- Reporting queries with multiple aggregations across joined tables
