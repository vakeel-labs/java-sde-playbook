# JVM Memory Model & Garbage Collection

Understanding how the JVM manages memory and reclaims objects is essential for diagnosing performance issues and answering senior-level interview questions.

## JVM Memory Areas

- **Heap** — All objects and arrays; split into Young Generation + Old Generation
- **Stack** — One per thread; holds stack frames (local variables, method calls)
- **Metaspace** — Class metadata (replaced PermGen in Java 8)
- **Code Cache** — JIT-compiled native code
- **Program Counter** — Address of currently executing instruction per thread

## Heap Generations

- **Young Generation**
  - Eden space — new objects allocated here
  - Survivor spaces (S0 and S1) — objects surviving one or more GC cycles
  - Minor GC — collected frequently, short pause
- **Old (Tenured) Generation**
  - Long-lived objects promoted from Young Gen
  - Major GC / Full GC — longer pause
- **Metaspace** — Class metadata; not part of heap

## Garbage Collection Algorithms

| GC | Java Version | Focus | Pause |
|----|-------------|-------|-------|
| Serial GC | All | Single thread, small heaps | Stop-the-world |
| Parallel GC | Java 8 default | Throughput | Stop-the-world |
| G1 GC | Java 9 default | Balanced throughput + latency | Predictable pause |
| ZGC | Java 15+ | Ultra-low latency | Sub-millisecond |
| Shenandoah | Java 15+ | Low latency (Red Hat) | Sub-millisecond |

## GC Roots & Reachability

- GC Roots: stack variables, static fields, JNI references
- Objects reachable from GC Roots are NOT collected
- Objects unreachable from GC Roots are eligible for collection

## Key JVM Flags to Know

- -Xms (initial heap size), -Xmx (max heap size)
- -XX:+UseG1GC, -XX:+UseZGC
- -XX:+PrintGCDetails, -XX:+PrintGCDateStamps

## Interview Questions

- What is the difference between Minor GC and Major GC?
- What is Stop-the-World (STW) and why does it happen?
- What causes an OutOfMemoryError and how do you debug it?
- What is a memory leak in Java? (GC won't collect it but you don't need it)
- Explain how G1 GC differs from Parallel GC
