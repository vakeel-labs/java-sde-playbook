# SQL Subqueries

Subqueries (nested queries) allow you to use the result of one query inside another, enabling complex data retrieval in a readable, modular way.

## Types of Subqueries

- **Scalar subquery** — Returns a single value; used in SELECT or WHERE
- **Row subquery** — Returns a single row
- **Table subquery** — Returns multiple rows and columns (used in FROM)
- **Correlated subquery** — References the outer query; re-executes per row

## Subquery Operators

- IN / NOT IN — Check membership in a list returned by subquery
- EXISTS / NOT EXISTS — Check if subquery returns any rows (more efficient than IN)
- ANY / ALL — Compare against any or all values in subquery result
- Scalar comparison (=, >, <) with single-value subqueries

## Subquery vs JOIN

- Subqueries are often more readable; JOINs often more performant
- EXISTS is typically faster than IN for large datasets
- Correlated subqueries can be slow — consider rewriting as a JOIN

## Practice Problems

- Find employees who earn more than the average salary
- Find customers who placed orders in the last 30 days but not last year
- Second highest salary without LIMIT
