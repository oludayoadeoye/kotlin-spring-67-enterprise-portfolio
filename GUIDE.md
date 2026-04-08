# Master Guide: 67 Spring Boot & Kotlin Projects

This guide details the architectural standards and infrastructure for the 67-project portfolio suite.

## 1. Core Architecture: Hexagonal (Clean)
Every project is structured into three distinct layers to ensure maximum maintainability:
- **Domain**: Pure business logic (Model + Service + Repository Ports). No Spring dependencies.
- **Infrastructure**: Outbound adapters (JPA Entities, Persistence Adapters, Flyway Migrations).
- **Application**: Inbound adapters (REST Controllers, DTOs, OpenAPI Documentation).

## 2. High-Performance Concurrency
- **Kotlin Coroutines**: All services and controllers use `suspend` functions for non-blocking execution.
- **Java 21 Virtual Threads**: Enabled via `spring.threads.virtual.enabled=true`. Blocking I/O (JPA) is wrapped in `withContext(Dispatchers.IO)` to leverage the lightweight thread pool.

## 3. Security & RBAC (OWASP Top 10)
- **Centralized RBAC**: Handled by **Keycloak** (Identity Provider) via Docker. Apps act as OAuth2 Resource Servers.
- **Hardening**: Standard `SecurityConfig.kt` enforces:
    - **CSP**: `script-src 'self'` to block XSS.
    - **HSTS**: Enforce HTTPS.
    - **Frame-Options**: Block Clickjacking.
- **Idempotency**: Financial apps require an `X-Idempotency-Key` header to prevent duplicate transactions.

## 4. Observability (ELK Stack)
All 67 apps stream logs to a centralized **ELK Stack** (Elasticsearch, Logstash, Kibana):
- **Logstash Appender**: JSON-formatted logs sent via TCP.
- **Kibana**: Single dashboard to monitor all 67 services.

## 5. Messaging & Background Tasks
- **RabbitMQ**: Used for worker queues in heavy processing apps (e.g., Speech/Image Recognition).
- **Kafka**: Used for real-time data streams in financial and monitoring apps (e.g., Stock Market, Cybersecurity).

## 6. Global Payments
- **Lemon Squeezy**: Integrated as the Merchant of Record to handle global tax (VAT/GST) compliance automatically.

## 7. How to Run
1. **Start Infrastructure**: `docker-compose -f docker-compose-infra.yml up -d`
2. **Run an App**: `cd <project-dir> && ./gradlew bootRun`
3. **Docs**: Access Swagger UI at `http://localhost:<port>/swagger-ui.html`
