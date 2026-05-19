# Medium Database Interview Questions

Intermediate-level questions requiring deeper SQL knowledge and conceptual understanding of database internals.

## SQL Query Topics

- Window functions (ROW_NUMBER, RANK, LAG, LEAD)
- Correlated subqueries
- SELF JOIN for hierarchical data
- CTEs (Common Table Expressions) with WITH clause
- Recursive CTEs for tree structures
- Multiple table joins with aggregations

## Conceptual Topics

- Explain ACID properties with real examples
- What are the four SQL isolation levels and what anomalies do they prevent?
- How does a B-tree index work internally?
- What is the difference between a clustered and non-clustered index?
- When would you use a composite index vs two separate indexes?
- Explain the N+1 query problem and how to fix it
- What is database normalization — 1NF, 2NF, 3NF?

## Sample Questions

1. Find the top 3 earning employees in each department (window function)
2. Calculate running total of sales per month
3. Find all employees and their manager names (SELF JOIN)
4. Find customers who ordered in January but not February
5. Detect and list all duplicate rows in a table
