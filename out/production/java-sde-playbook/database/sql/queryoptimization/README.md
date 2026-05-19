# SQL Query Optimization

Writing a correct query is only half the job — writing a fast query for large datasets requires understanding how the database engine executes it.

## Understanding Query Execution

- How to read EXPLAIN / EXPLAIN ANALYZE output
- Query execution order: FROM → JOIN → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT
- Cost-based optimizer
- Sequential scan vs index scan vs index-only scan

## Common Optimization Techniques

- Use indexes on columns in WHERE, JOIN ON, and ORDER BY
- Avoid SELECT *; select only needed columns
- Avoid functions on indexed columns in WHERE (prevents index usage)
- Use EXISTS instead of IN for large subquery results
- Avoid N+1 query problem (use JOIN or batch fetching)
- Use pagination (LIMIT/OFFSET) but avoid deep offsets — use keyset pagination instead
- Partition large tables

## Query Anti-Patterns

- Implicit type conversion defeating index usage
- OR conditions across different indexed columns
- Non-sargable predicates (WHERE YEAR(date_col) = 2023)
- Fetching too many rows and filtering in application code

## Tools

- EXPLAIN, EXPLAIN ANALYZE, EXPLAIN VERBOSE
- Query profiling (slow query log in MySQL)
- pg_stat_statements (PostgreSQL)
