# Consistent Hashing — Implementation Guide

## What to Build

A Java implementation of a consistent hashing ring that supports:
- Adding and removing nodes (servers)
- Mapping a key to the correct node
- Virtual nodes for uniform distribution

---

## Core Classes to Implement

### 1. `ConsistentHashRing.java`
The main class. Uses a `TreeMap<Integer, String>` to represent the ring.

**Fields:**
```
- TreeMap<Integer, String> ring         // position -> node name
- int virtualNodes                      // number of virtual copies per real node (e.g. 150)
- HashFunction hashFunction             // strategy for hashing
```

**Methods:**
```
+ addNode(String nodeName)              // add a real node + all its virtual nodes to the ring
+ removeNode(String nodeName)           // remove a real node + all its virtual nodes
+ getNode(String key)                   // return which node owns this key
+ getNodeForHash(int hash)              // internal: find next clockwise node on ring
+ getRingSnapshot()                     // return current state of ring for debugging
```

**Core logic in `getNode(key)`:**
```
1. hash the key -> int position
2. call ring.ceilingKey(position)        // find next entry >= position in TreeMap
3. if null (we wrapped past the end) -> ring.firstKey()   // wrap around to start
4. return ring.get(that key)            // return the node name at that position
```

**Core logic in `addNode(nodeName)`:**
```
for i in 0..virtualNodes:
    virtualKey = nodeName + "#VN" + i
    position   = hash(virtualKey)
    ring.put(position, nodeName)
```

**Core logic in `removeNode(nodeName)`:**
```
for i in 0..virtualNodes:
    virtualKey = nodeName + "#VN" + i
    position   = hash(virtualKey)
    ring.remove(position)
```

---

### 2. `HashFunction.java` (Interface)
```
interface HashFunction {
    int hash(String key);
}
```

### 3. `MD5HashFunction.java` (implements HashFunction)
Use `MessageDigest.getInstance("MD5")`, take first 4 bytes, convert to int.
This gives a good distribution across the 0..Integer.MAX_VALUE space.

### 4. `MurmurHashFunction.java` (implements HashFunction — optional)
Faster than MD5, non-cryptographic. Good for showing you know production hash choices.

### 5. `ConsistentHashRingDemo.java`
A main class that demonstrates:
- Adding 3 nodes (Server-A, Server-B, Server-C)
- Mapping 10 keys and printing which node each goes to
- Removing Server-B and showing which keys moved (and which stayed)
- Adding Server-D and showing redistribution

---

## Data Structures Internals

| Structure | Why |
|-----------|-----|
| `TreeMap<Integer, String>` | Sorted by position; `ceilingKey()` gives O(log N) clockwise lookup |
| `HashSet<String>` | Track which real nodes are added (for removeNode validation) |

**Why NOT HashMap?**  
HashMap is unordered — you cannot find the "next clockwise" node without scanning the whole ring. TreeMap's `ceilingKey()` does this in O(log N).

---

## Virtual Nodes — Why and How Many

**Without virtual nodes:**  
3 servers on a ring of 2^32 positions → statistically uneven distribution. One server might own 70% of the keyspace.

**With virtual nodes (150 per server):**  
Each server has 150 points on the ring → distribution approaches uniform. Removing one server spreads its load evenly across all remaining servers, not just one neighbor.

**Typical values used in production:**  
- Cassandra: 256 virtual nodes per physical node  
- Memcached: 150 virtual nodes (Ketama)  
- General guidance: 100–200 virtual nodes per node

---

## Step-by-Step: What Happens When a Node Is Added

```
Before: Ring has Server-A (150 vNodes) and Server-B (150 vNodes)
Action: addNode("Server-C")

1. Generate 150 virtual node keys: "Server-C#VN0", "Server-C#VN1", ..., "Server-C#VN149"
2. Hash each -> 150 positions on the ring
3. Insert all 150 positions into the TreeMap
4. Keys that previously mapped to the clockwise neighbor of each new position now map to Server-C
5. Only keys in the arcs just before each new Server-C vNode are affected
6. All other keys are UNCHANGED
```

**This is the key insight:** only ~1/N of keys are remapped when a node joins or leaves (N = number of nodes). With naive modular hashing (key % N), almost all keys remap.

---

## Step-by-Step: What Happens When a Node Is Removed

```
Before: Ring has Server-A, Server-B, Server-C
Action: removeNode("Server-B")

1. Compute all 150 virtual node positions for Server-B
2. Remove them from the TreeMap
3. Keys that were owned by Server-B positions now use ceilingKey() to find the NEXT node clockwise
4. Those keys are redistributed across remaining nodes (Server-A and Server-C)
5. Distribution is roughly even because vNodes were spread across the ring
```

---

## Acceptance Criteria

### Functional
- [ ] `addNode("Server-A")` inserts exactly `virtualNodes` entries into the ring
- [ ] `removeNode("Server-A")` removes exactly `virtualNodes` entries (ring returns to prior state)
- [ ] `getNode("some-key")` always returns a non-null node name as long as ring is non-empty
- [ ] `getNode("some-key")` returns the same node for the same key (deterministic)
- [ ] Wrap-around works: a key that hashes near Integer.MAX_VALUE wraps to the first node
- [ ] Removing a node redistributes its keys across ALL remaining nodes, not just one

### Distribution Quality
- [ ] With 3 nodes and 150 vNodes each, map 10,000 keys and verify each node owns between 25%–42% of keys (within ~40% of ideal 33%)
- [ ] With 5 nodes and 150 vNodes each, each node owns between 14%–26% (within ~30% of ideal 20%)

### Resilience
- [ ] `getNode(key)` on an empty ring throws `IllegalStateException` (not NullPointerException)
- [ ] `removeNode` on a node not in the ring throws `IllegalArgumentException`
- [ ] `addNode` with the same node name twice does NOT add duplicate vNodes (idempotent or throws)

### Performance
- [ ] `getNode(key)` runs in O(log N) where N = total virtual nodes on the ring
- [ ] `addNode` and `removeNode` run in O(V log N) where V = virtualNodes count

---

## Interview Questions — All Levels

### Conceptual (Asked Almost Every Time)

1. **What problem does consistent hashing solve that modular hashing (key % N) cannot?**  
   With key % N, adding or removing one server causes ~all keys to remap. Consistent hashing remaps only ~1/N of keys.

2. **Walk me through how `getNode(key)` works on the ring.**  
   Hash the key to a position → find the next node clockwise (ceilingKey) → wrap around if past the end.

3. **What are virtual nodes and why are they needed?**  
   Without vNodes, 3 physical servers may own very unequal portions of the ring by chance. Virtual nodes give each server many positions, making the distribution statistically uniform.

4. **How many virtual nodes should you use per server?**  
   100–256 is typical. More vNodes = better balance but more memory. Cassandra uses 256, Ketama (Memcached) uses 150.

5. **What data structure is used to implement the ring and why?**  
   `TreeMap<Integer, String>`. It keeps positions sorted and `ceilingKey()` gives O(log N) clockwise lookup without scanning.

6. **What fraction of keys are affected when a node is added or removed?**  
   Approximately 1/N (where N is the number of nodes). This is the fundamental advantage over modular hashing.

---

### Design Depth Questions

7. **How does consistent hashing handle replication? (Cassandra-style)**  
   For replication factor R, a key is stored on the R nodes clockwise from its position. Each key has a primary node and R-1 replicas on the next R-1 nodes.

8. **What happens if two virtual nodes hash to the same position (collision)?**  
   TreeMap.put() overwrites — one node's vNode silently replaces another's. In practice this is extremely rare with a good hash function and large key space. Production implementations detect and skip collisions.

9. **How would you handle a "hot key" (one key getting disproportionate traffic)?**  
   Consistent hashing doesn't solve hot keys — it distributes keys across nodes, not requests for the same key. Hot keys need application-level solutions: local caching, read replicas, or key splitting.

10. **How does adding a high-capacity server work? (Weighted consistent hashing)**  
    Assign more virtual nodes to higher-capacity servers. A server with 2x capacity gets 2x the virtual nodes → owns ~2x the keyspace → handles ~2x the traffic.

11. **What is the difference between consistent hashing and rendezvous hashing?**  
    Both solve the same problem. Rendezvous (HRW) hashing: for each key, compute hash(key, node) for all N nodes; assign to the node with the highest score. No ring data structure needed, but O(N) per lookup vs O(log N) for ring.

12. **How does Cassandra use consistent hashing differently from a cache like Redis?**  
    Cassandra uses vNodes for data partitioning with replication. Redis Cluster uses hash slots (0–16383) with a fixed mapping — it's a simpler form of consistent hashing with 16,384 "virtual nodes" shared across cluster nodes.

---

### System Design Application Questions

13. **Design a distributed cache using consistent hashing. How do you handle node failures?**  
    Ring maps keys to cache servers. On failure: keys remap to next node (cache miss, load from DB). Recovery: new node joins ring; warm up from DB or from replica. Use replication factor 2+ to avoid thundering herd on failure.

14. **In a URL shortener, how would you use consistent hashing to shard the DB?**  
    Hash the short code -> ring position -> database shard. All operations for a short code go to the same shard. Adding a new shard only migrates ~1/N of short codes.

15. **What are the limitations of consistent hashing?**  
    - Does not solve hot keys (popular content)  
    - Node heterogeneity handled only by vNode count (coarse-grained)  
    - Data migration still needed when nodes join/leave (just less of it)  
    - Ring state must be shared/synchronized across all clients in a distributed system

---

## Files to Create in This Folder

```
consistent-hashing/
├── README.md                          (already exists — theory)
├── implementation.md                  (this file — implementation guide)
├── HashFunction.java                  (interface)
├── MD5HashFunction.java               (implementation)
├── ConsistentHashRing.java            (core ring implementation)
└── ConsistentHashRingDemo.java        (demo + distribution stats)
```
