# Kubernetes for Microservices

Kubernetes (K8s) is the industry-standard platform for automating deployment, scaling, and management of containerized applications.

## Core Objects

| Object | Purpose |
|--------|---------|
| Pod | Smallest unit; one or more containers |
| ReplicaSet | Ensures N replicas of a Pod are running |
| Deployment | Manages ReplicaSets; supports rolling updates |
| Service | Stable network endpoint for Pods (ClusterIP, NodePort, LoadBalancer) |
| ConfigMap | Inject configuration (non-sensitive) |
| Secret | Inject sensitive configuration (encoded) |
| Namespace | Logical isolation within a cluster |
| Ingress | HTTP routing rules; exposes services externally |
| HPA | Horizontal Pod Autoscaler — auto-scale based on CPU/memory |

## Service Types

- **ClusterIP** — Internal cluster access only (default)
- **NodePort** — Expose on each node's IP at a static port
- **LoadBalancer** — Provision a cloud load balancer (AWS ELB, GCP LB)
- **ExternalName** — Map to an external DNS name

## Deployments & Rolling Updates

- Deployment manages rolling updates: new Pods come up before old ones go down
- Rollback: kubectl rollout undo deployment/name

## Health Checks

- **Liveness probe** — Is the container running? Restart if fails
- **Readiness probe** — Is the container ready to receive traffic? Remove from Service if fails
- **Startup probe** — For slow-starting containers

## Interview Questions

- What is the difference between a Deployment and a StatefulSet?
- How does Kubernetes handle service discovery internally (kube-dns)?
- What is a Horizontal Pod Autoscaler and how does it work?
- What is the difference between a ConfigMap and a Secret?
