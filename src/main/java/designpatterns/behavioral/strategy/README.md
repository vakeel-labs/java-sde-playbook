# Strategy Pattern

Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Intent

Extract a group of algorithms into separate classes and make them interchangeable. The context delegates work to a strategy object instead of implementing variants itself.

## Real-World Examples

- Sorting: pass a Comparator to Collections.sort() — the comparator is the strategy
- Payment: CreditCardStrategy, PayPalStrategy, CryptoStrategy all implement PaymentStrategy
- Compression: ZipStrategy, RarStrategy, GzipStrategy all implement CompressionStrategy
- Route planning: FastestRoute, ShortestRoute, ScenicRoute strategies

## Interview Questions

- How does Strategy differ from Template Method?
- What is the difference between Strategy and State?
- How does Java's Comparator interface exemplify Strategy?
