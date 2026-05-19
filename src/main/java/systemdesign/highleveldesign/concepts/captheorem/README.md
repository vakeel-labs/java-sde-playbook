# CAP Theorem

Eric Brewer's CAP theorem states that a distributed system can only guarantee two of the following three properties simultaneously: Consistency, Availability, and Partition Tolerance.

## The Three Properties

- **Consistency (C)** — Every read receives the most recent write or an error. All nodes see the same data at the same time.
- **Availability (A)** — Every request receives a non-error response (though it may not be the most recent data).
- **Partition Tolerance (P)** — The system continues to operate despite arbitrary network partitions (nodes cannot communicate).

## The Trade-off

Network partitions are unavoidable in real distributed systems. Therefore, you must choose between:

- **CP (Consistency + Partition Tolerance)** — System becomes unavailable during a partition to preserve consistency. Examples: HBase, Zookeeper, etcd, MongoDB (with write concern)
- **AP (Availability + Partition Tolerance)** — System remains available during a partition but may return stale data. Examples: Cassandra, CouchDB, DynamoDB (eventually consistent), Eureka

## PACELC Extension

PACELC extends CAP: Even when there is no partition (during normal operation), you must trade off between **Latency (L)** and **Consistency (C)**.

## Real-World Application

| Database | CAP Category | Notes |
|----------|-------------|-------|
| Cassandra | AP | Tunable consistency per query |
| MongoDB | CP (by default) | Can tune to AP |
| MySQL (single node) | CA | Not partition tolerant |
| Zookeeper | CP | Linearizable reads |
| DynamoDB | AP | Offers optional strong consistency |

## Interview Questions

- What does CAP theorem state and what are its limitations?
- Is MySQL CA, CP, or AP?
- How does Cassandra achieve AP with tunable consistency?
- What is the PACELC theorem and how does it extend CAP?
- In a banking system, would you choose CP or AP? Why?
