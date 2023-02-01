# Microservices With Spring Boot
Microservices using Spring Boot and Spring Cloud Eureka

### Features

- **Spring Cloud Eureka** to create Client/Server Microservice Architecture 
- Microservices:
  - Product Service
  - Order Service -> Inventory Service (Sync Communication)
  - Order Service -> Notification Service (Async Communication)
  - **Eureka Discovery Service** as Server (http://localhost:8761)
  - **API Gateway** to build Routes to services above and Authorization System using **Keycloak**
- Event Streaming Plataform to Async Communication using **Kafka**
- **Zipkin** to Tracing request
- Circuit Breaker with **Resilience4j**
- Database: **Mariadb**
- **TestContainer** to create Mariadb container

### Follow the image of the project architecture accomplished in the course of the *Programming Techie* channel on the root of this project (spring_microservices.png)
