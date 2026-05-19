# Java 11–17 Features

Modern Java has evolved significantly. Features from Java 9 through Java 17 (LTS) introduce more expressive, concise, and performant code patterns.

## Java 9

- Module system (Project Jigsaw)
- Collection factory methods: List.of(), Set.of(), Map.of()
- Stream improvements: takeWhile(), dropWhile(), ofNullable()
- Optional.ifPresentOrElse(), Optional.stream()
- Private methods in interfaces

## Java 10

- Local variable type inference: var x = new ArrayList<String>()

## Java 11 (LTS)

- String methods: isBlank(), strip(), lines(), repeat()
- var in lambda parameters: (var x) -> x.length()
- HTTP Client API (standardized)
- Files.readString(), Files.writeString()

## Java 14

- Switch Expressions (preview → standard): return values from switch

## Java 15–16

- Text Blocks (multiline strings with """...""")
- Pattern Matching for instanceof: if (obj instanceof String s) { s.toUpperCase() }
- Records (preview)

## Java 17 (LTS)

- **Records** — Immutable data classes with auto-generated equals, hashCode, toString, getters
- **Sealed Classes** — Restrict which classes can extend a class (sealed, permits, non-sealed)
- **Pattern Matching for instanceof** (standard)
- Switch Expressions (standard)

## Interview Questions

- What are Records in Java 17 and when would you use them?
- What is the difference between a Record and a final class with all-args constructor?
- How do Sealed classes support exhaustive pattern matching?
- What is the advantage of text blocks over string concatenation?
