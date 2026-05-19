# SQL Window Functions

Window functions perform calculations across a set of rows related to the current row — without collapsing the result like GROUP BY does.

## Syntax

```
function_name() OVER (
  [PARTITION BY column]
  [ORDER BY column]
  [ROWS/RANGE frame_clause]
)
```

## Ranking Functions

- ROW_NUMBER() — Unique sequential number per partition
- RANK() — Rank with gaps for ties
- DENSE_RANK() — Rank without gaps for ties
- NTILE(n) — Divide rows into n equal buckets
- PERCENT_RANK(), CUME_DIST()

## Value Functions

- LAG(col, n) — Access value n rows before current row
- LEAD(col, n) — Access value n rows after current row
- FIRST_VALUE(col), LAST_VALUE(col)
- NTH_VALUE(col, n)

## Aggregate Window Functions

- SUM() OVER, AVG() OVER, COUNT() OVER — Running totals
- Frame clause: ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW

## Practice Problems

- Rank employees by salary within each department
- Calculate running total of sales by date
- Find the salary difference between an employee and the next highest earner
- Identify top 3 products per category
