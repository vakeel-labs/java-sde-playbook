# Hard Database Interview Questions

Advanced questions covering query optimization, database design for scale, and deep internals — typically asked at senior and staff engineer levels.

## SQL Optimization Topics

- Reading and interpreting EXPLAIN ANALYZE output
- Rewriting correlated subqueries as JOINs for performance
- Choosing the right index type for a given query pattern
- Keyset pagination vs offset pagination at scale
- Partial indexes and their use cases

## Database Design Topics

- Design the schema for a URL shortener / Twitter / e-commerce system
- How would you shard a users table by user_id?
- Design an audit logging system that tracks all changes to a table
- How would you implement a leaderboard that updates in real-time?

## Conceptual Deep-Dives

- Explain MVCC (Multiversion Concurrency Control) and how it avoids read locks
- How does PostgreSQL implement REPEATABLE READ without locks?
- What is a WAL (Write-Ahead Log) and why is it needed?
- When does a query NOT use an index even when one exists?
- Compare B-tree vs LSM-tree storage engines (InnoDB vs RocksDB)
- Explain the trade-offs of eventual consistency vs strong consistency

## Sample Questions

1. You have a query running in 8 seconds on 100M rows — walk me through debugging it
2. Design the database schema for an Instagram-like application
3. How would you handle a hotspot partition in a Cassandra cluster?
