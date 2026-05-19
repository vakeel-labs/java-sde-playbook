# SQL vs NoSQL

One of the most common system design decision points: when to use a relational database and when to use a NoSQL database.

## SQL (Relational Databases)

Examples: MySQL, PostgreSQL, Oracle, SQL Server

### Characteristics
- Schema-on-write: fixed schema defined before inserting data
- ACID transactions across multiple tables
- Strong consistency
- Powerful querying with JOINs and aggregations
- Vertical scaling (scale up) + limited horizontal scaling

### When to Use SQL
- Data has clear relationships and complex joins are needed
- ACID compliance is required (financial systems, e-commerce orders)
- Complex reporting and analytics queries
- Data is structured and schema is unlikely to change frequently

## NoSQL Databases

### Types and Examples
- **Document**: MongoDB (flexible JSON documents)
- **Key-Value**: Redis, DynamoDB (simple key-value lookups)
- **Wide-Column**: Cassandra, HBase (time-series, IoT, high write throughput)
- **Graph**: Neo4j (highly connected data, social networks)
- **Search**: Elasticsearch (full-text search)

### Characteristics
- Schema-on-read: flexible or no schema
- Horizontal scaling (scale out easily)
- Eventual consistency (AP in CAP) by default; some support strong consistency
- Optimized for specific access patterns
- Limited support for complex joins and transactions

### When to Use NoSQL
- Data is unstructured or semi-structured
- High write throughput at massive scale
- Simple, well-defined access patterns (avoid joins)
- Flexible or evolving schema
- Need for specific capabilities (graph traversal, full-text search, caching)

## Common Combinations

Most large systems use multiple databases:
- SQL for transactional data (orders, payments)
- Redis for caching
- Elasticsearch for search
- Cassandra for time-series metrics

## Interview Questions

- When would you choose MongoDB over MySQL?
- Can NoSQL databases handle ACID transactions?
- What is eventual consistency and when is it acceptable?
- Why is Cassandra better than MySQL for write-heavy time-series data?
