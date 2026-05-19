# Flyweight Pattern

Uses sharing to efficiently support a large number of similar objects. Reduces memory usage by reusing common state among many objects.

## Intent

Minimize memory use by sharing as much state as possible with similar objects. Useful when a huge number of objects would otherwise exhaust available RAM.

## Key Concepts

- **Intrinsic state** — Shared, context-independent state stored in the flyweight
- **Extrinsic state** — Context-dependent state stored outside the flyweight and passed in
- **FlyweightFactory** — Creates and caches flyweight objects; returns cached instance if exists

## Real-World Examples

- Text editor: each character glyph is a flyweight (font, size = intrinsic; position = extrinsic)
- Game engines: tree/bullet/soldier flyweights with shared mesh data, unique position
- Java String pool — String literals are cached/reused
- Integer.valueOf() cache (-128 to 127 in Java)

## Interview Questions

- What is intrinsic vs extrinsic state?
- How does Java's String interning relate to Flyweight?
- When is Flyweight NOT appropriate?
