# Ride Sharing System (Uber / Lyft)

Design a ride-sharing platform where riders request trips and drivers fulfill them with real-time matching.

## Functional Requirements
- Rider requests a ride with pickup and drop-off location
- System finds nearby available drivers and notifies them
- Driver accepts the ride request
- Track driver location in real-time
- Calculate ETA and fare estimate
- Multiple vehicle categories: UberGo, UberX, UberXL, UberPremium
- Ratings for drivers and riders post-trip
- Ride history and receipts

## Core Entities
- Rider
- Driver
- Vehicle (by category)
- TripRequest
- Trip
- TripStatus (Requested, DriverAssigned, DriverEnRoute, InProgress, Completed, Cancelled)
- Location / GeoCoordinate
- FarePriceCalculator
- PaymentStrategy
- Rating

## Design Patterns Applied
- **Strategy**: DriverMatchingStrategy (nearest, highest rating), FareCalculationStrategy
- **Observer**: Notify rider of driver assignment; notify driver of ride requests
- **State**: TripStatus state machine
- **Factory**: VehicleFactory, DriverMatcherFactory
- **Decorator**: SurgeDecorator wraps base FareCalculator to add surge pricing
