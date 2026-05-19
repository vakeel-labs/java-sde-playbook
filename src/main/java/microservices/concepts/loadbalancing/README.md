# Load Balancing in Microservices

Distributes incoming requests across multiple service instances to ensure no single instance is overwhelmed, improving availability and performance.

## Types of Load Balancing

### Client-Side Load Balancing
- Client holds the list of instances (from service registry)
- Client selects an instance using a load balancing algorithm
- Example: Spring Cloud LoadBalancer, Netflix Ribbon (deprecated)

### Server-Side Load Balancing
- A dedicated load balancer (hardware or software) distributes traffic
- Client is unaware of instances; just calls one address
- Example: NGINX, HAProxy, AWS ELB, Kubernetes Service

## Load Balancing Algorithms

- **Round Robin** — Distribute requests equally in sequence
- **Weighted Round Robin** — Some instances get more traffic (based on capacity)
- **Least Connections** — Route to instance with fewest active connections
- **IP Hash** — Route same client IP to same instance (session stickiness)
- **Random** — Pick a random instance

## Health Checks

Load balancers must detect unhealthy instances and stop routing to them:
- Active health checks: probe each instance periodically
- Passive health checks: detect failures from actual request errors

## Interview Questions

- What is the difference between client-side and server-side load balancing?
- How does Kubernetes Services handle load balancing?
- What is session stickiness (sticky sessions) and what problems does it cause?
