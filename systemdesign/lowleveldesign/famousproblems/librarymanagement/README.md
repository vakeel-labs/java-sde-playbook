# Library Management System

Design a library management system for a public library with book lending, member management, and fine calculation.

## Functional Requirements
- Members can search books by title, author, subject, publication date
- Members can check out, return, and renew books
- Library can have multiple copies of the same book
- System tracks due dates and calculates fines for late returns
- Members can reserve books currently checked out
- Librarians can add/remove books and manage members

## Core Entities
- Library (Singleton)
- Book (catalog entry — title, ISBN, author)
- BookItem (physical copy of a book)
- Member (account, borrowed books, fines)
- Librarian
- Catalog (search functionality)
- BookReservation
- BookLending (checkout record)
- FineCalculator

## Design Patterns Applied
- **Observer**: Notify members when reserved book becomes available
- **Strategy**: FineCalculationStrategy (different rules for different member types)
- **Singleton**: Library and Catalog
- **Iterator**: Searching through catalog
