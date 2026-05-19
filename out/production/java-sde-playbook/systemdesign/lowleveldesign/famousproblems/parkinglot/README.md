# Parking Lot System

Design a parking lot system that can handle multiple floors, different vehicle types, and various parking spot sizes.

## Functional Requirements
- Support multiple floors in a parking lot
- Support different vehicle types: Motorcycle, Car, Truck/Bus
- Support different spot sizes: Small, Medium, Large
- Vehicle parks in the nearest available spot of appropriate size
- Generate a parking ticket on entry with timestamp and spot details
- Calculate parking fee on exit based on duration and vehicle type
- Support multiple entry and exit gates

## Core Entities
- ParkingLot (Singleton)
- ParkingFloor
- ParkingSpot (Small, Medium, Large)
- Vehicle (Motorcycle, Car, Truck) — abstract class
- ParkingTicket
- Gate (EntryGate, ExitGate)
- ParkingAttendant
- PaymentStrategy (Hourly, Daily, Monthly)

## Design Patterns Applied
- **Singleton**: ParkingLot — only one lot instance
- **Factory**: VehicleFactory, SpotFactory
- **Strategy**: PricingStrategy for different fee calculation models
- **Observer**: Notify when lot is full/available
