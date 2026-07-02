# Day 04 - Spring Boot Microservices with Eureka Server

## Project Overview

This project demonstrates the implementation of **Service Discovery using Netflix Eureka Server** in a Spring Boot Microservices architecture.

The objective of this assignment is to understand how multiple microservices can automatically register themselves with a Eureka Server and communicate without hardcoding hostnames and port numbers.

This project consists of four Spring Boot applications:

1. Eureka Server
2. Payment Service
3. Cart Service
4. Bank Payment Service

---

# Architecture

```text
                   Eureka Server
                  (Port : 8761)

      ┌────────────┼────────────┐
      │            │            │
      ▼            ▼            ▼

Payment      Cart Service    BankPayment
Service

(8989)         (9009)         (9090)
```

All microservices register themselves with Eureka Server and become discoverable within the ecosystem.

---

# Technologies Used

* Java 17
* Spring Boot 4.1.0
* Spring Cloud Netflix Eureka
* Maven
* Spring Web
* STS / Eclipse
* Postman

---

# Project Structure

```text
Eureka-Microservices

│
├── EurekaServer01
│
├── PaymentService
│
├── CartService
│
└── BankPayment
```

---

# Microservices Description

## 1. Eureka Server

Acts as the Service Registry.

All client services register themselves here.

### Port

```properties
server.port=8761
```

### Application Name

```properties
spring.application.name=EUREKA-SERVER
```

### Main Annotation

```java
@EnableEurekaServer
```

### Dependency

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

### Configuration

```properties
server.port=8761

spring.application.name=EUREKA-SERVER

eureka.client.register-with-eureka=false

eureka.client.fetch-registry=false
```

---

## 2. Payment Service

Represents the payment microservice.

### Port

```properties
server.port=8989
```

### Application Name

```properties
spring.application.name=PAYMENT-SERVICE
```

### Annotation

```java
@EnableDiscoveryClient
```

### Eureka Configuration

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

### Endpoint

```java
@GetMapping("/payment")
```

### URL

```text
http://localhost:8989/payment
```

---

## 3. Cart Service

Represents shopping cart functionality.

### Port

```properties
server.port=9009
```

### Application Name

```properties
spring.application.name=CART-SERVICE
```

### Eureka Configuration

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

### Endpoint

```java
@GetMapping("/cart")
```

### URL

```text
http://localhost:9009/cart
```

---

## 4. Bank Payment Service

Represents bank-side payment processing.

### Port

```properties
server.port=9090
```

### Application Name

```properties
spring.application.name=BANK-PAYMENT
```

### Eureka Configuration

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

### Endpoint

```java
@GetMapping("/bank")
```

### URL

```text
http://localhost:9090/bank
```

---

# Dependencies Used

## Eureka Server

```xml
spring-cloud-starter-netflix-eureka-server
```

---

## Client Services

```xml
spring-cloud-starter-netflix-eureka-client
```

```xml
spring-boot-starter-web
```

---

# Running the Project

## Step 1

Start Eureka Server.

Run:

```text
EurekaServer01Application.java
```

Open:

```text
http://localhost:8761
```

Expected dashboard:

```text
Instances currently registered with Eureka
```

Initially:

```text
No instances available
```

---

## Step 2

Start Payment Service.

Refresh Eureka dashboard.

Expected:

```text
PAYMENT-SERVICE
```

appears.

---

## Step 3

Start Cart Service.

Refresh dashboard.

Expected:

```text
CART-SERVICE
```

appears.

---

## Step 4

Start Bank Payment Service.

Refresh dashboard.

Expected:

```text
BANK-PAYMENT
```

appears.

---

# Eureka Dashboard

After starting all services, Eureka should display:

```text
Instances currently registered with Eureka

PAYMENT-SERVICE

CART-SERVICE

BANK-PAYMENT
```

---

# Testing Services

### Payment

```text
GET

http://localhost:8989/payment
```

---

### Cart

```text
GET

http://localhost:9009/cart
```

---

### Bank Payment

```text
GET

http://localhost:9090/bank
```

---

# Postman Testing

### Payment

```text
GET
http://localhost:8989/payment
```

---

### Cart

```text
GET
http://localhost:9009/cart
```

---

### Bank Payment

```text
GET
http://localhost:9090/bank
```

---

# Service Registration Process

When a microservice starts:

```text
Microservice Startup

↓

Reads Eureka Configuration

↓

Connects to Eureka Server

↓

Registers itself

↓

Sends heartbeat periodically

↓

Eureka Dashboard updates
```

---

# Advantages of Eureka

* Eliminates hardcoded URLs
* Automatic service registration
* Service discovery mechanism
* Supports dynamic scaling
* Helps in load balancing
* Simplifies microservices communication

---

# What I Learned

Through this project, I learned:

* What Service Discovery is.
* Difference between client and server registration.
* How Eureka Server works.
* How microservices register automatically.
* How Eureka maintains active instances.
* How to configure Spring Cloud Eureka.
* How service discovery improves scalability.

---

# Day 04 Assignment Summary

In this assignment, multiple Spring Boot microservices were created and connected to a centralized Eureka Server.

Each service successfully registered itself with Eureka, enabling dynamic discovery of available services without relying on manually configured IP addresses or ports.

This project provided a practical understanding of Service Discovery, which forms the foundation of modern cloud-native microservices architectures.

---

# Future Enhancements

This project can be extended by integrating:

* API Gateway
* OpenFeign Client
* Config Server
* Resilience4j
* Circuit Breaker
* Distributed Tracing
* Centralized Logging
* Load Balancing

---

# Author

**Md Parvezuddin**

B.Tech CSE

Java Full Stack Developer (Learning)

