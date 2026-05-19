# Online Shopping Cart

Design an online shopping cart system as part of an e-commerce platform.

## Functional Requirements
- Users browse and search products
- Add/remove products to cart, update quantities
- Apply discount coupons and promotional codes
- Place order (cart → order)
- Multiple payment options
- Order status tracking

## Core Entities
- User / Customer
- Product
- Category
- Cart, CartItem
- Order, OrderItem
- OrderStatus (Pending, Confirmed, Shipped, Delivered, Cancelled)
- Discount / CouponCode
- Payment (PaymentStrategy)
- Address

## Design Patterns Applied
- **Observer**: Notify user of order status changes
- **Strategy**: DiscountStrategy (percentage, flat, buy-one-get-one), PaymentStrategy
- **Decorator**: PriceDecorator wraps base price to apply tax, discount, delivery charges
- **Command**: OrderCommand for placing and cancelling orders
- **Factory**: OrderFactory
