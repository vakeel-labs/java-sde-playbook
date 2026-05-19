# Consistent Hashing

Consistent hashing is a technique for distributing data across nodes in a way that minimizes data movement when nodes are added or removed.

## The Problem with Naive Hashing

With N servers: server = hash(key) % N

When N changes (server added/removed): nearly all keys remap to different servers → massive data migration and cache invalidation.

## How Consistent Hashing Works

1. Map server nodes to positions on a virtual ring (0 to 2^32)
2. Map each key to a position on the ring using the same hash function
3. A key is assigned to the first server clockwise from its position on the ring
4. When a server is added: only the keys between it and the previous server move
5. When a server is removed: only its keys move to the next server clockwise

## Virtual Nodes (VNodes)

Each physical server is represented by multiple points on the ring (virtual nodes).
- Ensures more uniform distribution
- Larger servers can have more virtual nodes (weighted assignment)
- Reduces the impact of a single node failure

## Applications

- Distributed caches (Memcached, Redis Cluster)
- Distributed databases (Cassandra, DynamoDB)
- Load balancing
- CDN edge node selection

## Interview Questions

- What problem does consistent hashing solve that modular hashing cannot?
- What is a virtual node and why is it necessary?
- How does Cassandra use consistent hashing for data distribution?
- How do you handle hot spots in consistent hashing?
