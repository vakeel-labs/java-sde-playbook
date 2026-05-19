# Database Sharding & Partitioning

Techniques to distribute a large database across multiple nodes, enabling horizontal scaling when a single database server cannot handle the load.

## Partitioning vs Sharding

- **Partitioning** — Splitting a table within a single database instance (logical split)
- **Sharding** — Splitting data across multiple database instances (physical split); each shard is an independent database

## Types of Partitioning

### Horizontal Partitioning (Sharding)
- Split rows across partitions/shards
- Example: Users 1–1M in shard 1, Users 1M–2M in shard 2

### Vertical Partitioning
- Split columns across different tables or databases
- Example: User profile columns in one DB, user activity columns in another

## Sharding Strategies

### Range-Based Sharding
- Shard by range of a key (e.g., user_id 0–999 → shard 1)
- Pro: simple range queries
- Con: hotspots (new users always go to the last shard)

### Hash-Based Sharding
- shard = hash(user_id) % num_shards
- Pro: even distribution
- Con: range queries are inefficient; resharding is painful

### Directory-Based Sharding
- A lookup table maps keys to shards
- Pro: flexible, supports any distribution
- Con: lookup table is a bottleneck and single point of failure

## Consistent Hashing

Minimizes data movement when shards are added or removed. See [Consistent Hashing](../consistent-hashing).

## Challenges of Sharding

- **Cross-shard joins** — Cannot easily JOIN across shards
- **Cross-shard transactions** — No atomic transactions across shards
- **Resharding** — Adding shards requires moving data (downtime risk)
- **Non-uniform data (hotspots)** — Some shards may receive much more traffic

## Interview Questions

- What is the difference between partitioning and sharding?
- How do you handle cross-shard queries?
- What is a hotspot shard and how do you fix it?
- Why is consistent hashing better than modular hashing for sharding?
