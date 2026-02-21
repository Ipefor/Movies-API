# 🎬 Movies API

**Movies API** is a Spring Boot backend project built to explore **role-based data access** and compare different persistence strategies while following a **clean, layered architecture**.

The application retrieves movie data from a relational database and adapts the information returned depending on the requesting role (**USER** vs **ADMIN**).

---

## 🏗️ Clean Architecture Approach

The project is intentionally structured using a **layered design** to ensure separation of concerns, maintainability, and scalability:
Controller → Service → Repository → Database

- **Controller Layer**  
  Handles HTTP requests and maps them to application use cases.

- **Service Layer**  
  Contains the business logic and decides how data should be accessed depending on the user role.

- **Repository Layer**  
  Implements two alternative persistence strategies:
  - **JPA** — ORM-based, entity-driven access.
  - **JDBC** — Direct SQL for fine-grained control and flexibility.

This dual approach allows evaluating trade-offs between abstraction and performance while keeping the architecture clean and modular.

---

## 🎯 Project Goals

- Demonstrate how **different persistence mechanisms can coexist** in the same application.
- Explore **role-aware data delivery** and query specialization.
- Apply **Spring Boot best practices** within a maintainable, production-style structure.
- Reinforce architectural principles such as **separation of concerns** and **testable design**.

---

## 🛠️ Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA  
- JDBC Template  
- MySQL  
- Maven  

---

## 🚀 Run the Application

Configure your database in `application.properties`, then run:

```bash
mvn spring-boot:run
```
API available at:
http://localhost:8080
