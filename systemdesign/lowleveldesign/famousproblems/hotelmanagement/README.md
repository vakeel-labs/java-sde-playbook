# Hotel Management System

Design a hotel management system covering reservations, room management, billing, and housekeeping.

## Functional Requirements
- Search available rooms by date range, type, and amenities
- Book a room (reservation with guest details and dates)
- Check in and check out guests
- Generate and process bills (room charges + extras)
- Housekeeping management — track room cleaning status
- Different room types: Single, Double, Suite, Penthouse

## Core Entities
- Hotel (Singleton)
- Room (abstract: SingleRoom, DoubleRoom, Suite)
- Reservation
- Guest
- RoomStatus (Available, Booked, Occupied, UnderMaintenance, Dirty)
- HousekeepingTask
- Bill / Invoice
- Payment (PaymentStrategy: Cash, Card, Online)

## Design Patterns Applied
- **Factory**: RoomFactory creates rooms by type
- **Observer**: Notify housekeeping when room is checked out
- **Strategy**: PricingStrategy (weekday vs weekend rates, seasonal pricing)
- **State**: Room state transitions (Available → Booked → Occupied → Dirty → Available)
