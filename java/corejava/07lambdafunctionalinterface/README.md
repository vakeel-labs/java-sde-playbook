# Lambda Expressions & Functional Interfaces

Java 8 introduced lambda expressions and functional interfaces, enabling a more concise and functional style of programming.

## Lambda Expressions

- Syntax: (parameters) -> expression or (parameters) -> { statements }
- No parameters: () -> System.out.println("hello")
- One parameter: x -> x * x (parentheses optional)
- Multiple parameters: (a, b) -> a + b

## Functional Interfaces (@FunctionalInterface)

An interface with exactly one abstract method — a target for lambda expressions.

| Interface | Method | Use |
|-----------|--------|-----|
| Predicate<T> | test(T) → boolean | Filter / condition check |
| Function<T,R> | apply(T) → R | Transform input to output |
| Consumer<T> | accept(T) → void | Consume without returning |
| Supplier<T> | get() → T | Produce a value |
| BiFunction<T,U,R> | apply(T,U) → R | Two inputs, one output |
| UnaryOperator<T> | apply(T) → T | Same input and output type |
| BinaryOperator<T> | apply(T,T) → T | Two same-type inputs |

## Method References

- Static method: ClassName::staticMethod
- Instance method of a specific instance: instance::method
- Instance method of an arbitrary instance: ClassName::instanceMethod
- Constructor: ClassName::new

## Composing Functions

- Predicate: and(), or(), negate()
- Function: andThen(), compose()

## Interview Questions

- What is a functional interface? Can it have default methods?
- What is the difference between Function.andThen() and Function.compose()?
- How does method reference differ from a lambda?
- What is a closure in the context of Java lambdas? (effectively final)
