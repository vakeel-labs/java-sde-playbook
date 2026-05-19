# High Level Design (HLD)

High Level Design focuses on the architecture of distributed systems — how to design systems that handle millions of users, with high availability, low latency, and fault tolerance.

## Contents

| Folder | Description |
|--------|-------------|
| [concepts](./concepts) | Core HLD building blocks every interview requires |
| [famous-problems](./famous-problems) | Famous system design problems with full architecture |

## HLD Interview Framework

1. **Requirements clarification** (5 min)
   - Functional requirements (what it does)
   - Non-functional requirements (scale, latency, availability, consistency)

2. **Capacity estimation** (5 min)
   - Daily Active Users (DAU), requests per second (QPS)
   - Storage requirements (GB/TB/PB)
   - Bandwidth estimation

3. **API design** (5 min)
   - Define REST endpoints or event contracts

4. **Data model** (5 min)
   - Choose SQL vs NoSQL; design schema

5. **High-level architecture** (10 min)
   - Draw major components: clients, API gateway, services, databases, caches

6. **Deep dive** (15 min)
   - Focus on the hardest components; discuss algorithms and trade-offs

7. **Trade-offs and bottlenecks** (5 min)
   - Identify SPOFs, hotspots, scaling strategies
