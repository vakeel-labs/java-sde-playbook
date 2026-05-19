# Elasticsearch

Elasticsearch is a distributed, RESTful search and analytics engine built on Apache Lucene. It powers full-text search, log analysis, and observability platforms.

## Core Concepts

- Index, Document, and Field (analogous to database, row, column)
- JSON document storage with inverted index
- REST API based interaction (no SQL)
- Near real-time (NRT) search

## Key Features

- **Full-text search** — Tokenization, stemming, relevance scoring (TF-IDF / BM25)
- **Aggregations** — Metric and bucket aggregations (like SQL GROUP BY + stats)
- **Geo-search** — Distance queries, bounding box search
- **Auto-complete** — Completion suggester and edge n-gram tokenizer
- **Highlighting** — Show matched excerpts in results

## Architecture

- Cluster → Node → Index → Shard (primary + replica)
- Sharding for scale, replicas for availability
- Master node, data nodes, coordinating nodes

## System Design Use Cases

- Search functionality in e-commerce (product search)
- Log aggregation and analytics (ELK stack: Elasticsearch + Logstash + Kibana)
- Full-text search in social platforms
- Monitoring and alerting pipelines
