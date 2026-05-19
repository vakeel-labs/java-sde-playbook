# Apache Cassandra

Cassandra is a wide-column, distributed NoSQL database designed for high write throughput and linear scalability. It powers systems like Netflix, Instagram, and Discord at massive scale.

## Core Concepts

- Wide-column store: keyspace → table → row → columns
- Partition key and clustering key design
- CQL (Cassandra Query Language) — SQL-like syntax
- Denormalization: model data by access patterns, not relationships
- No joins, no transactions across partitions

## How Cassandra Achieves Scale

- **Consistent hashing** — Distributes data across nodes using a ring
- **Replication factor** — Each row stored on N nodes
- **Tunable consistency** — Choose between ONE, QUORUM, ALL per query
- **Leaderless architecture** — No single point of failure
- **LSM tree storage** — Optimized for writes (MemTable → SSTable)

## When to Use Cassandra

- Write-heavy workloads (10x more writes than reads)
- Time-series data (sensor data, logs, metrics)
- Data that can be partitioned by a natural key (user_id, date)
- Requires multi-region, active-active replication

## System Design Examples

- Activity feeds (partition by user_id, cluster by timestamp)
- IoT sensor data (partition by device_id + date)
- Chat message history (Discord uses Cassandra for message storage)
