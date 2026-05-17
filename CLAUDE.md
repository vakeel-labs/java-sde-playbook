# Java Interview Preparation — Project Context

## What This Repository Is

A structured self-learning repository for cracking top tech company interviews (FAANG/product companies). The owner is learning everything from scratch, progressively — one topic at a time. **No code exists yet.** Only folder structure and README files have been created so far.

## Owner's Learning Goal

Learn and implement all major interview topics in Java:
- Data Structures & Algorithms (DSA)
- Low Level Design (LLD) — OOPs, SOLID, Design Patterns, classic LLD problems
- High Level Design (HLD) — distributed systems architecture
- Database — SQL, NoSQL, query optimization
- Java Core & Advanced — OOPs to JVM internals
- Microservices — Spring Boot/Cloud, Docker, Kubernetes

## Repository Structure

```
coding/
├── algorithms/          # 18 DSA chapters (01-arrays → 18-union-find)
├── database/            # SQL (9 chapters), NoSQL (4 DBs), interview Q&A
├── design-patterns/     # All 23 GoF patterns (creational/structural/behavioral)
├── java/                # Core Java: OOPs → Collections → Streams → JVM
├── microservices/       # Concepts, Spring Boot/Cloud, Docker, K8s
└── system-design/
    ├── low-level-design/    # SOLID + 12 famous LLD problems
    └── high-level-design/   # 12 HLD concepts + 13 famous system designs
```

Every folder has a README.md explaining what will be implemented there.

## How the Owner Works

- Learns one topic/folder at a time — asks Claude to **plan then implement** when ready
- Does NOT want code written speculatively — only when explicitly asked
- Will ask "what to do in this folder" before starting any topic
- Wants Java implementations with notes and interview Q&A per topic

## Workflow Pattern

When the owner says "let's start [topic]" or "implement [folder]":
1. Confirm which folder we're working in
2. Ask if they want a plan first or go straight to implementation
3. Implement Java code inside the correct folder
4. Add interview questions and notes alongside the code

## Current Status (as of May 2026)

- Folder structure: COMPLETE (139 folders)
- README.md files: COMPLETE (140 files — one per folder + root)
- Git: initialized locally, not yet pushed to GitHub

### Implementation Progress

| Folder | Status | Notes |
|--------|--------|-------|
| `system-design/high-level-design/concepts/consistent-hashing/` | implementation.md DONE, Java code PENDING | Owner will write the Java code themselves |

### implementation.md Convention

For each topic, before writing Java code, an `implementation.md` is created in the same folder containing:
- Class breakdown (what classes to create, their fields and methods)
- Step-by-step logic for each method
- Data structure choices with justification
- Acceptance criteria (functional, distribution quality, resilience, performance)
- All interview questions (conceptual → design depth → system design application)

The owner reads the `implementation.md` and writes the Java code themselves. Claude does NOT write the Java code unless explicitly asked.

## Tech Stack

- Language: Java (primary — Java 8 to Java 17 features)
- Build tool: to be decided (Maven or Gradle)
- Frameworks: Spring Boot, Spring Cloud (for microservices section)
- Databases: MySQL/PostgreSQL (SQL), MongoDB, Redis, Cassandra (NoSQL)

## Important Instructions for Claude

- **Never write code speculatively** — only when the owner asks to implement a specific topic
- **Always work inside the correct folder** for whatever topic is being discussed
- **Follow the numbered order** in algorithms/ (01 → 18) unless owner requests otherwise
- **Each implementation should include**: Java class(es), inline comments for tricky parts, and a short summary of patterns used
- **Design patterns** go in `design-patterns/` folder; when applied to LLD problems they go in `system-design/low-level-design/famous-problems/`
- The owner is learning, so **explain the why** behind design decisions, not just the what
