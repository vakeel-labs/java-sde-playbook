# SQL Indexes

Indexes dramatically speed up data retrieval but add overhead for writes. Knowing when and how to index is critical for database performance tuning.

## Types of Indexes

- **B-tree Index** — Default type; supports =, <, >, BETWEEN, LIKE 'prefix%'
- **Hash Index** — Supports only = comparisons; faster for exact lookups
- **Composite Index** — Index on multiple columns; column order matters
- **Unique Index** — Enforces uniqueness; automatically created for PRIMARY KEY
- **Covering Index** — Index includes all columns needed by the query (index-only scan)
- **Partial Index** — Index on a subset of rows (WHERE clause on index)
- **Full-Text Index** — Optimized for text search

## Key Concepts

- How B-tree index works (balanced tree, leaf node pointers)
- Index cardinality and selectivity
- The leftmost prefix rule for composite indexes
- Index scan vs table scan (full scan)
- EXPLAIN / EXPLAIN ANALYZE output reading

## When NOT to Index

- Small tables (full scan is faster)
- Columns with very low cardinality (e.g., boolean flags)
- Tables with heavy write workloads

## Interview Questions

- What is a covering index and why is it beneficial?
- How does a composite index on (A, B, C) help queries on (A), (A,B), (A,B,C)?
- What is an index on a foreign key and when is it necessary?
