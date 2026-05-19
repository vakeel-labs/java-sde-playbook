# Replication & Consistency

Replication copies data across multiple nodes for high availability and disaster recovery. The trade-off is keeping replicas consistent with the primary.

## Why Replication?

- **High availability** — If one node fails, replicas serve traffic
- **Read scalability** — Distribute read traffic across replicas
- **Geographic distribution** — Serve users from nearby replicas
- **Disaster recovery** — Data backup in case of data center failure

## Replication Models

### Single-Leader (Master-Slave / Primary-Replica)
- All writes go to the leader; replicated to followers
- Reads can go to any replica (may be slightly stale)
- Failover: elect a new leader when primary fails
- Examples: MySQL replication, PostgreSQL streaming replication

### Multi-Leader (Multi-Master)
- Multiple leaders accept writes; sync with each other
- Good for multi-region active-active
- Conflict resolution is complex (last-write-wins, vector clocks, CRDTs)
- Examples: MySQL Galera Cluster, CouchDB

### Leaderless (Peer-to-Peer)
- All nodes accept reads and writes
- Quorum reads and writes for consistency (W + R > N)
- Examples: Cassandra, DynamoDB, Riak

## Consistency Models

- **Strong Consistency** — All reads reflect the latest write. Requires coordination. Slower.
- **Eventual Consistency** — All replicas will converge eventually. Reads may be stale. Faster.
- **Read-your-Writes** — You always see your own writes (even if others don't yet)
- **Monotonic Reads** — Once you read a value, you never read an older value

## Replication Lag

The delay between a write on the leader and it appearing on replicas. Under high write load, this can be seconds or more.

## Interview Questions

- What is the difference between synchronous and asynchronous replication?
- How does a database elect a new leader after primary failure?
- What is the quorum condition (W + R > N) in leaderless replication?
- How do you handle replication lag in a read-heavy system?
