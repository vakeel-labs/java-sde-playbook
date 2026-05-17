# SQL Aggregations & GROUP BY

Aggregation functions summarize data across multiple rows. Combined with GROUP BY and HAVING, they form the core of analytical queries.

## Aggregate Functions

- COUNT(*), COUNT(column), COUNT(DISTINCT column)
- SUM(column)
- AVG(column)
- MIN(column), MAX(column)
- GROUP_CONCAT / STRING_AGG

## GROUP BY & HAVING

- GROUP BY: partition rows into groups before aggregation
- HAVING: filter groups after aggregation (vs WHERE which filters rows before)
- Multiple column GROUP BY
- Grouping sets, ROLLUP, and CUBE (advanced)

## Common Patterns

- Count records per category
- Find categories with more than N records (HAVING)
- Running totals and cumulative aggregations
- Percentage of total calculations

## Interview Problems

- Find the department with the highest average salary
- Count orders per customer per month
- Find products never ordered
- Top N per category
