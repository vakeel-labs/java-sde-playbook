# Movie Ticket Booking System (BookMyShow)

Design an online movie ticket booking system for multiple cities, cinemas, and shows.

## Functional Requirements
- Browse movies currently showing in a city
- Select a cinema, show time, and available seats
- Reserve seats (temporary hold while user pays)
- Process payment and confirm booking
- Generate booking confirmation with QR code
- Cancellation and refund support
- Different seat types: Standard, Premium, Recliner

## Core Entities
- Movie
- Cinema / Theater
- CinemaHall / Screen
- Show (movie + screen + date + time)
- Seat (by type)
- SeatReservation (temporary hold)
- Booking / Ticket
- Customer
- Payment (PaymentStrategy)
- ShowStatus (Available, AlmostFull, HouseFull)

## Design Patterns Applied
- **Singleton**: BookingController / TicketingService
- **Strategy**: SeatSelectionStrategy, PaymentStrategy
- **Observer**: Notify user on booking confirmation, cancellation
- **State**: SeatStatus (Available → HeldTemporarily → Booked)
- **Factory**: TicketFactory
