# Spring Boot for Microservices

Spring Boot is the de facto framework for building Java microservices. It provides auto-configuration, embedded servers, and production-ready features out of the box.

## Core Features

- **Auto-configuration** — Detects libraries on classpath and configures them automatically
- **Embedded server** — Tomcat/Jetty/Undertow bundled; no WAR deployment needed
- **Spring Boot Starters** — Dependency bundles for common use cases (web, data, security)
- **Actuator** — Production metrics, health checks, and management endpoints
- **Spring Boot DevTools** — Hot reload during development

## Building a REST Microservice

- @RestController, @RequestMapping, @GetMapping, @PostMapping
- @PathVariable, @RequestParam, @RequestBody
- ResponseEntity for fine-grained HTTP response control
- Exception handling with @ControllerAdvice and @ExceptionHandler

## Configuration

- application.properties / application.yml
- @Value injection
- @ConfigurationProperties for typed configuration
- Profiles (@Profile, spring.profiles.active)

## Spring Data JPA

- @Entity, @Repository, JpaRepository
- Derived query methods
- @Query with JPQL
- Transaction management with @Transactional

## Testing

- @SpringBootTest — full application context
- @WebMvcTest — test REST layer only
- @DataJpaTest — test persistence layer only
- MockMvc for controller testing

## Interview Questions

- What is the difference between @Component, @Service, @Repository, @Controller?
- How does Spring Boot auto-configuration work?
- What is Spring Actuator and which endpoints does it expose?
- How do you handle versioning in Spring Boot REST APIs?
