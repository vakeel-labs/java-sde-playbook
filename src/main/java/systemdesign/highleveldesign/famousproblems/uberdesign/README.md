# Uber (Ride Sharing Platform)

## Scale
100M+ trips/month, 5M drivers globally, sub-second driver matching, 4-second GPS update interval

## Core Challenges
Geo-based driver matching, real-time location tracking at scale, dynamic surge pricing, trip state machine

## APIs
- POST /rides/request { pickup, dropoff, ride_type } -> trip_id (driver matching begins async)
- GET /rides/{trip_id}/status -> status + driver location + ETA
- POST /rides/{trip_id}/accept (driver accepts)
- POST /rides/{trip_id}/complete
- GET /rides/{trip_id}/fare -> calculated fare

## Core Components
- **Location Service** - Ingests driver GPS updates every 4 seconds; stores in Redis Geo (geospatial index)
- **Matching Service** - On ride request, finds nearest available drivers via GEORADIUS query; sends request to top N candidates
- **Trip Service** - Manages trip lifecycle state machine; stores trip data in PostgreSQL
- **Surge Pricing Service** - Divides city into hex grid cells (H3); computes supply/demand ratio per cell; real-time multiplier
- **Notification Service** - Push (FCM/APNs) + WebSocket to inform drivers/riders of events
- **ETA Service** - Road graph with real-time traffic; Dijkstra/A* for routing

## Deep Dive
- **Driver location storage**: Redis Geo commands (GEOADD key longitude latitude member); GEORADIUS returns drivers within N km sorted by distance. Update every 4 seconds = ~5M drivers x 15 updates/min = 75M writes/min -> Redis cluster handles this easily.
- **Driver matching algorithm**: GEORADIUS within 5km; filter by: available status, vehicle type match, driver score; send request to top 3 candidates; first to accept gets the ride; 10-second timeout then try next.
- **Trip state machine**: REQUESTED -> DRIVER_ASSIGNED -> DRIVER_EN_ROUTE -> DRIVER_ARRIVED -> IN_TRIP -> COMPLETED (or CANCELLED at any point)
- **Surge pricing**: H3 hexagonal grid; real-time supply (available drivers) vs demand (open ride requests) per cell; multiplier = f(demand/supply ratio); updated every 30 seconds

## Key Trade-offs
- Location update frequency: 4s balances freshness vs write load; can increase to 2s for active trips
- Matching radius: start small (1km), expand if no drivers found; balance driver utilization vs ETA
- Surge calculation granularity: smaller cells = more accurate; larger cells = more supply/demand data per cell
