# Food Delivery App (Swiggy / Zomato)

Design a food delivery platform where customers order food from restaurants and delivery partners fulfill the orders.

## Functional Requirements
- Customers browse restaurants and menus, place orders
- Restaurants receive and accept/reject orders
- System assigns the nearest available delivery partner
- Order state machine: Placed → Accepted → Preparing → Out for Delivery → Delivered
- Real-time tracking of delivery partner location
- Rating and review system for restaurants and delivery partners
- Payment processing

## Core Entities
- Customer
- Restaurant
- MenuCategory, MenuItem
- Order, OrderItem
- DeliveryPartner
- OrderStatus (Placed, Accepted, Preparing, OutForDelivery, Delivered, Cancelled)
- Location / GeoCoordinate
- Payment (PaymentStrategy)
- Rating

## Design Patterns Applied
- **Observer**: Notify customer of order status changes; notify restaurant of new orders
- **Strategy**: DeliveryPartnerAssignmentStrategy (nearest, least loaded, etc.)
- **State**: Order moves through well-defined states
- **Builder**: OrderBuilder for assembling complex orders
- **Factory**: PaymentFactory
