# Generics in Java

Generics enable type-safe code that works with different types at compile time, eliminating ClassCastException at runtime and reducing code duplication.

## Core Concepts

- Generic classes: class Box<T>
- Generic methods: <T> T getFirst(List<T> list)
- Type bounds: <T extends Comparable<T>> (upper bound)
- Lower bounds: List<? super Integer> (lower bounded wildcard)
- Unbounded wildcard: List<?> (unknown type)

## Type Erasure

Java generics are implemented via type erasure — generic type information is removed at runtime. This is why:
- You cannot use instanceof with generic types
- You cannot create arrays of generic types (new T[10] is illegal)
- Runtime type is Object (or the bound), not T

## PECS Rule (Producer Extends, Consumer Super)

- Use List<? extends T> when you only read from the collection (producer)
- Use List<? super T> when you only write to the collection (consumer)

## Common Interview Questions

- What is type erasure and what are its limitations?
- Explain the difference between List<Object>, List<?>, and raw List
- What is the PECS principle?
- Why can't you create generic arrays in Java?
- What is reifiable type?
