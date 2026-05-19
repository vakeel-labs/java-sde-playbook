# Java Collections Framework

The Java Collections Framework provides reusable data structures and algorithms. Knowing the internals, trade-offs, and thread-safety of each collection is a key interview topic.

## Core Interfaces

- Collection → List, Set, Queue
- Map (separate hierarchy)
- Iterable → Collection

## List Implementations

| Class | Backed By | Random Access | Insert/Delete | Thread Safe |
|-------|-----------|---------------|---------------|-------------|
| ArrayList | Dynamic array | O(1) | O(n) | No |
| LinkedList | Doubly linked list | O(n) | O(1) at known pos | No |
| Vector | Dynamic array | O(1) | O(n) | Yes (synchronized) |

## Set Implementations

| Class | Order | Duplicates | Null | Thread Safe |
|-------|-------|-----------|------|-------------|
| HashSet | No order | No | One null | No |
| LinkedHashSet | Insertion order | No | One null | No |
| TreeSet | Sorted (natural/Comparator) | No | No null | No |

## Map Implementations

| Class | Order | Null Keys | Thread Safe |
|-------|-------|-----------|-------------|
| HashMap | No order | One null key | No |
| LinkedHashMap | Insertion/access order | One null key | No |
| TreeMap | Sorted by key | No null key | No |
| Hashtable | No order | No null key | Yes |
| ConcurrentHashMap | No order | No null key | Yes |

## Queue / Deque

- PriorityQueue — min-heap by default; O(log n) offer/poll
- ArrayDeque — resizable array deque; faster than LinkedList for stack/queue
- LinkedList — implements both List and Deque

## Internals to Know

- HashMap internal: array of buckets + linked list + red-black tree (Java 8+)
- HashMap load factor (0.75) and rehashing
- HashSet is backed by HashMap
- TreeMap uses Red-Black Tree internally

## Interview Questions

- What is the difference between HashMap and ConcurrentHashMap?
- How does HashMap handle collisions internally?
- Why is the load factor 0.75 in HashMap?
- What happens if you don't override hashCode() when overriding equals()?
- When would you use LinkedHashMap over HashMap?
