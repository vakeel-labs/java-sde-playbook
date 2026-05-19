# Java 8 Features

Java 8 was the most impactful Java release in years, fundamentally changing how Java code is written. These features are heavily tested in interviews.

## Major Features

### Lambda Expressions
Concise way to represent anonymous function implementations. See [Lambda & Functional Interfaces](../07-lambda-functional-interface).

### Streams API
Functional-style processing of sequences of elements. See [Streams API](../06-streams-api).

### Optional<T>
Wrapper to handle nullable values without NullPointerException:
- Optional.of(), Optional.ofNullable(), Optional.empty()
- get(), orElse(), orElseGet(), orElseThrow()
- map(), flatMap(), filter()
- isPresent(), isEmpty() (Java 11)

### Default and Static Interface Methods
- default methods: add method implementations to interfaces without breaking existing implementations
- static methods: utility methods on interfaces

### New Date/Time API (java.time)
Immutable, thread-safe replacement for java.util.Date and Calendar:
- LocalDate, LocalTime, LocalDateTime — no timezone
- ZonedDateTime — with timezone
- Instant — machine-readable timestamp
- Duration (time-based), Period (date-based)
- DateTimeFormatter for parsing and formatting

### Other Features

- Method references (ClassName::method)
- Collectors improvements (groupingBy, partitioningBy, joining)
- CompletableFuture — async programming
- Parallel arrays (Arrays.parallelSort)
- Nashorn JavaScript engine (now removed)
- Base64 encoding/decoding (java.util.Base64)

## Interview Questions

- What are the advantages of the new Date/Time API over java.util.Date?
- What is the difference between orElse() and orElseGet() in Optional?
- Can you override a default interface method?
- What problem does Optional solve?
