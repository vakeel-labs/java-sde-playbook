# System Design

Comprehensive coverage of both Low Level Design (LLD) and High Level Design (HLD) — the two major pillars of system design interviews.

## Structure

| Folder | Description |
|--------|-------------|
| [low-level-design](./low-level-design) | OOPs design, design patterns applied to real problems |
| [high-level-design](./high-level-design) | Scalable distributed system design |

## LLD vs HLD

| | Low Level Design (LLD) | High Level Design (HLD) |
|-|------------------------|-------------------------|
| Focus | Class design, OOPs, design patterns | Architecture, scalability, infrastructure |
| Duration | 45–60 min | 45–60 min |
| Output | Class diagrams, code | Architecture diagrams, component breakdown |
| Key Skills | SOLID, GoF patterns, clean code | CAP theorem, caching, sharding, queues |
| Example | Design a Parking Lot | Design Twitter |

## Interview Approach

For LLD:
1. Gather requirements (functional + non-functional)
2. Identify entities/objects and their relationships
3. Define interfaces and abstract classes
4. Apply relevant design patterns
5. Handle edge cases

For HLD:
1. Clarify requirements and estimate scale (users, QPS, storage)
2. Define APIs
3. Design the data model
4. Draw the high-level architecture
5. Deep dive into critical components
6. Discuss trade-offs
