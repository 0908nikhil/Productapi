# 🚀 Product API (Spring Boot + JWT)

A production-ready RESTful API for managing Products with secure JWT authentication, refresh token rotation, and role-based authorization.

---

## 🧰 Tech Stack

* Java 17
* Spring Boot 3
* Spring Security + JWT
* Spring Data JPA (Hibernate)
* PostgreSQL
* Swagger / OpenAPI
* Docker & Docker Compose
* JUnit 5 & Mockito
* Lombok

---

## 🏗️ Architecture

The project follows **Layered Architecture**:

```
Controller → Service → Repository → Database
```

### 🔹 Controller Layer

* Handles HTTP requests
* Validates input
* Returns JSON response

### 🔹 Service Layer

* Contains business logic
* Handles transactions
* Manages token rotation

### 🔹 Repository Layer

* Database access using Spring Data JPA
* Supports pagination

### 🔹 Security Layer

* JWT authentication
* Refresh token rotation
* Role-based authorization

---

## 🔐 Security Features

* JWT Access Token
* Refresh Token Rotation
* Role-based Authorization (ADMIN / USER)
* BCrypt password hashing
* Stateless authentication
* CORS enabled

---

## 📦 API Base URL

```
/api/v1
```

---

## 📌 Main Endpoints

| Method | Endpoint                | Description            |
| ------ | ----------------------- | ---------------------- |
| POST   | `/api/v1/auth/login`    | User login             |
| POST   | `/api/v1/auth/refresh`  | Refresh token          |
| GET    | `/api/v1/products`      | Get all products       |
| POST   | `/api/v1/products`      | Create product (ADMIN) |
| GET    | `/api/v1/products/{id}` | Get product by id      |
| DELETE | `/api/v1/products/{id}` | Delete product         |

---

## ▶️ Local Setup

### 1️⃣ Clone repository

```bash
git clone https://github.com/0908nikhil/product-api.git
cd product-api
```

---

### 2️⃣ Start PostgreSQL using Docker

```bash
docker-compose up -d postgres
```

---

### 3️⃣ Build project

bash
mvn clean package


### 4️⃣ Run Spring Boot

bash
mvn spring-boot:run



## 👨‍💻 Author

**Nikhil Dhawale**

---

## 📄 License

Apache 2.0
