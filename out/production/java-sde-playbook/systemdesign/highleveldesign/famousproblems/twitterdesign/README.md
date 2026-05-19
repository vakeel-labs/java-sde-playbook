# Twitter (Social Media Feed)

## Scale
300M DAU, 600 tweets/sec write, 600K reads/sec, celebrities with 100M+ followers

## Core Challenges
News feed generation (push vs pull), handling celebrities (hotspot), real-time feed

## APIs
- POST /tweets { content, media? } -> tweet_id
- GET /timeline -> home feed (tweets from followed users)
- POST /follow { followee_id }
- GET /search?q=keyword -> tweets

## Core Components
- **Tweet Service** - Store tweets in Cassandra (partition by user_id, cluster by tweet_id)
- **Social Graph Service** - Stores follower/following relationships (Cassandra or Redis sets)
- **Fan-out Service** - Distributes new tweets to followers' timelines
- **Timeline Cache (Redis)** - Pre-built timelines per user (list of tweet IDs, capped at 800)
- **Media Service** - Images/videos stored in S3; served via CDN
- **Search Service** - Elasticsearch for tweet search and trending topics

## Deep Dive
- **Feed Generation - Push (Fan-out on Write)**: On tweet, push tweet_id to all followers' Redis timeline lists. Fast reads (O(1)). Problem: celebrities with 100M followers = 100M writes per tweet.
- **Feed Generation - Pull (Fan-out on Read)**: On timeline load, fetch tweets from all followed users and merge. Slow for users following many people.
- **Hybrid Approach**: Regular users (<10K followers) use push. Celebrity tweets fetched at read time and merged with push-based timeline.
- **Data model**: Tweet stored once in Cassandra; timeline caches store only tweet IDs; load actual tweet data in parallel

## Key Trade-offs
- Push vs Pull for feed generation: Push favors read performance, Pull favors write performance
- Timeline cache size: Cap at N recent tweets; older tweets fetched from DB on scroll
- Cassandra vs MySQL: Cassandra for tweets (write-heavy, partition by user, no complex queries needed)
