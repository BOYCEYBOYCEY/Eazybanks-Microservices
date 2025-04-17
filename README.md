# Eazy Banks Microservices

This project implements a set of core banking microservices for managing cards, loans, and accounts. Built with Spring Boot, it leverages a microservices architecture to ensure scalability, maintainability, and resilience.

## Key Features

* **Modular Design:** Composed of three independent services:
    * **Cards Service:** Manages user credit and debit cards.
    * **Loans Service:** Handles user loan applications and management.
    * **Accounts Service:** Manages user bank accounts and balances.
* **Spring Boot Framework:** Built using the robust and feature-rich Spring Boot framework for rapid application development.
* **RESTful APIs:** Each microservice exposes well-defined RESTful APIs for seamless communication between services and external clients.
* **OpenAPI Documentation:** Comprehensive API documentation generated using OpenAPI (Swagger) for easy understanding and integration.
* **Containerization with Docker:** The entire application, including individual services and infrastructure components, is containerized using Docker for consistent deployment across different environments.
* **Centralized Configuration with Config Server:** Utilizes a Spring Cloud Config Server to manage application configurations, reading from a remote GitHub repository for version control and centralized management.
* **Automated Configuration Updates with Webhooks:** Implemented GitHub webhooks to automatically trigger configuration updates in the Config Server upon changes in the configuration repository.
* **Asynchronous Communication with RabbitMQ:** Leverages RabbitMQ for asynchronous communication between microservices, improving performance and decoupling.
* **Service Discovery with Eureka (or similar):** Implemented service discovery (e.g., Spring Cloud Eureka) to enable dynamic location and communication between microservices.
* **API Gateway (e.g., Spring Cloud Gateway):** Utilizes an API Gateway to provide a single entry point for clients, handling routing, security, and other cross-cutting concerns.

## Technologies Used

* Java
* Spring Boot
* RESTful APIs
* OpenAPI (Swagger)
* Docker
* Spring Cloud Config Server
* GitHub Webhooks
* RabbitMQ
* Service Discovery (e.g., Spring Cloud Eureka)
* API Gateway (e.g., Spring Cloud Gateway)

## Getting Started (Example - Adjust as needed)

1.  **Clone the repository (if public):**
    ```bash
    git clone <repository-url>
    ```
2.  **Build the Docker images:** Navigate to the project root and build the Docker images using Docker Compose (if configured):
    ```bash
    docker-compose build
    ```
3.  **Run the application using Docker Compose:**
    ```bash
    docker-compose up -d
    ```
4.  **Access the API documentation:** Once the services are running, you can typically access the OpenAPI documentation endpoints (e.g., `http://<api-gateway-host>:<api-gateway-port>/v3/api-docs`).

## Further Information

[Optional: Add links to specific service READMEs or other relevant documentation]
