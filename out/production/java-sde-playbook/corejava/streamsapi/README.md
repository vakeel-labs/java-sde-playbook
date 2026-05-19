# Java Streams API

The Streams API (Java 8) enables declarative, functional-style processing of collections. It supports parallelism without explicit thread management.

## Core Concepts

- Stream is not a data structure — it is a view of data with lazy evaluation
- Stream pipeline: Source → Intermediate Operations → Terminal Operation
- Streams are consumed once; cannot be reused

## Intermediate Operations (lazy — return Stream)

- filter(Predicate) — keep matching elements
- map(Function) — transform each element
- flatMap(Function) — flatten nested collections
- distinct(), sorted(), limit(n), skip(n), peek()

## Terminal Operations (eager — trigger execution)

- forEach(Consumer) — iterate; returns void
- collect(Collector) — gather into List, Set, Map
- reduce(identity, BinaryOperator) — fold into single value
- count(), min(), max(), findFirst(), findAny()
- anyMatch(), allMatch(), noneMatch()

## Collectors

- Collectors.toList(), toSet(), toMap()
- Collectors.groupingBy(Function) — group by key
- Collectors.partitioningBy(Predicate) — split into true/false groups
- Collectors.joining(delimiter) — string joining
- Collectors.counting(), summingInt(), averagingInt()

## Parallel Streams

- parallelStream() — uses ForkJoinPool.commonPool()
- When to use: CPU-bound, large data, no shared mutable state
- When NOT to use: IO-bound, small data, order matters

## Interview Questions

- What is the difference between map() and flatMap()?
- How is lazy evaluation achieved in Streams?
- When would a parallel stream be slower than a sequential stream?
- What is the difference between findFirst() and findAny()?
