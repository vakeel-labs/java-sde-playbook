# MongoDB

MongoDB is a document database that stores data as BSON (Binary JSON) documents. It is the most popular NoSQL database for general-purpose use cases.

## Core Concepts

- Documents, Collections, and Databases
- BSON data types (ObjectId, Date, Array, Embedded Document)
- Schema design: embedding vs referencing documents
- CRUD operations: insertOne/Many, findOne/find, updateOne/Many, deleteOne/Many

## Querying

- Query operators: $eq, $ne, $gt, $lt, $in, $nin, $and, $or, $not
- Projection (include/exclude fields)
- Sort, limit, skip
- Aggregation pipeline: $match, $group, $project, $sort, $lookup, $unwind

## Indexing in MongoDB

- Single field index
- Compound index
- Multikey index (on array fields)
- Text index (full-text search)
- TTL index (auto-expire documents)

## System Design Relevance

- When to use MongoDB over SQL
- Data modeling for social feeds, product catalogs, user profiles
- Sharding strategies (hashed vs ranged)
- Replica sets for high availability
