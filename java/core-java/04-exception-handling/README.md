# Exception Handling in Java

Exception handling allows programs to respond to runtime errors gracefully. Understanding the exception hierarchy and best practices is important for writing robust Java code.

## Exception Hierarchy

- Throwable
  - Error (JVM errors — OutOfMemoryError, StackOverflowError; do not catch)
  - Exception
    - Checked Exceptions (IOException, SQLException — must be declared or caught)
    - RuntimeException (Unchecked — NullPointerException, ArrayIndexOutOfBoundsException)

## Key Concepts

- try-catch-finally block
- try-with-resources (Java 7) — AutoCloseable ensures resource cleanup
- Multi-catch: catch (IOException | SQLException e)
- Rethrowing exceptions
- Chained exceptions (new RuntimeException("msg", cause))
- Creating custom exceptions

## Checked vs Unchecked

| | Checked | Unchecked (RuntimeException) |
|-|---------|------------------------------|
| Must declare/catch | Yes (compile error) | No |
| Indicates | External failure (IO, network) | Programming error |
| Examples | IOException, SQLException | NullPointerException, IllegalArgumentException |

## Best Practices

- Catch specific exceptions, not Exception or Throwable
- Never swallow exceptions silently (empty catch blocks)
- Use finally or try-with-resources for cleanup
- Log exceptions with meaningful context
- Custom exceptions for domain-specific error conditions

## Interview Questions

- What is the difference between throw and throws?
- When does finally NOT execute?
- What is exception chaining and why is it useful?
- Can you catch an Error? Should you?
