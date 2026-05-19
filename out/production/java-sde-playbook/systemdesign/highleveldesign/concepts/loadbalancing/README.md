# Load Balancing

Distributes incoming network traffic across multiple servers to ensure no single server becomes a bottleneck, improving availability and reliability.

## Why Load Balancing?

- Prevents any single server from being overwhelmed
- Provides horizontal scalability — add more servers behind the LB
- Enables zero-downtime deployments (rolling updates)
- Health checks automatically remove unhealthy instances

## Load Balancing Algorithms

| Algorithm | Description | Best For |
|-----------|-------------|---------|
| Round Robin | Requests distributed sequentially | Equal server capacity |
| Weighted Round Robin | Servers with more capacity get more requests | Heterogeneous servers |
| Least Connections | Route to server with fewest active connections | Long-lived connections |
| Least Response Time | Route to fastest server | Latency-sensitive workloads |
| IP Hash | Same client always goes to same server | Session stickiness |
| Random | Pick a random server | Simple, uniform workloads |

## L4 vs L7 Load Balancing

- **L4 (Transport Layer)** — Operates on IP and TCP; faster; no content inspection
- **L7 (Application Layer)** — Understands HTTP; can route based on URL, headers, cookies; enables A/B testing, canary deployments

## Load Balancer Types

- **Hardware LB** — Expensive, high performance (F5)
- **Software LB** — NGINX, HAProxy (most common)
- **Cloud LB** — AWS ELB/ALB, GCP Load Balancer (managed, auto-scaling)

## Health Checks

- Active: probe each server periodically (HTTP GET /health → expect 200)
- Passive: detect failures from real request errors
- Unhealthy instances removed from rotation automatically

## Interview Questions

- What happens if the load balancer itself fails? (Answer: multiple LBs + DNS failover or Anycast)
- What is session stickiness and what problems does it cause?
- How does a Layer 7 LB enable canary deployments?
