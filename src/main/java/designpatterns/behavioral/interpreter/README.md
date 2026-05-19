# Interpreter Pattern

Given a language, defines a representation for its grammar along with an interpreter that uses the representation to interpret sentences of the language.

## Intent

Define a grammar for a simple language, represent sentences in that language as abstract syntax trees (AST), and provide an interpreter to process those trees.

## Structure

- **AbstractExpression** — Declares an interpret() method
- **TerminalExpression** — Implements interpret() for terminal grammar symbols
- **NonterminalExpression** — Implements interpret() by calling sub-expressions recursively
- **Context** — Contains global information needed by the interpreter

## Real-World Examples

- SQL parsing (each clause is an expression)
- Regular expression engines
- Mathematical expression evaluators
- Java compiler parsing Java source code

## Interview Questions

- When is Interpreter appropriate vs using a parsing library?
- What are the performance drawbacks of Interpreter?
- How does Interpreter relate to Composite pattern?
