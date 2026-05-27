# 📚 Books API

**Books API** is a Spring Boot backend application that manages book data stored in a relational database and exposes it through a role-based REST API.

The system differentiates between USER and ADMIN roles, returning different levels of information depending on access permissions.

The main goal of this project is to explore and compare two persistence approaches within the same backend architecture: JPA (ORM-based access) and JDBC (direct SQL queries).

---

## 🏗️ Architecture

The application follows a layered architecture to ensure separation of concerns:
Controller → Service → Repository → Database

- **Controller Layer**  
  Handles HTTP requests and exposes REST endpoints.

- **Service Layer**  
  Contains the business logic and applies role-based rules.

- **Repository Layer**  
  Implements two two persistence strategies (JPA and JDBC):
  - **JPA** — ORM-based, entity-driven access.
  - **JDBC** — Direct SQL for fine-grained control and flexibility.

---

## 🎯 Key Features

- Role-based access control (USER / ADMIN)
- Movie data retrieval and management
- Dual persistence implementation (JPA vs JDBC)
- Separation between business logic and data access
- RESTful API design with Spring Boot

---

## 🛠️ Tech Stack

Java · Spring Boot · Spring Data JPA · JDBC Template · MySQL · Maven

---

## 🚀 Run the Application

Configure your database in `application.properties` and run:

```bash
mvn spring-boot:run
```
API available at:
http://localhost:8080
