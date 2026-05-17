# Iterator Pattern

Provides a way to access elements of a collection sequentially without exposing its underlying representation.

## Intent

Extract traversal behavior into a separate iterator object, decoupling the collection from the traversal algorithm.

## Real-World Examples

- Java Iterator and Iterable interfaces
- Java enhanced for-each loop (uses Iterable/Iterator internally)
- Database ResultSet (iterates over query results)
- File system directory traversal

## Java Specifics

- java.util.Iterator — hasNext(), next(), remove()
- java.lang.Iterable — iterator() method, enables for-each
- ListIterator — bidirectional iteration with previous()

## Interview Questions

- What is the difference between Iterator and for-loop?
- How does Java's for-each work internally?
- What is a fail-fast iterator vs fail-safe iterator in Java?
