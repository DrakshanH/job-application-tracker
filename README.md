# 💼 Job Application Tracker

> A RESTful backend application built with **Spring Boot** to manage and track job applications throughout the job search process.

---

## 🚀 About the Project

**Job Application Tracker** is a backend application designed to organize job applications in one place.

The project is being developed using **Spring Boot** and follows a layered architecture to practice real-world backend development concepts such as REST APIs, service-layer design, database persistence, DTOs, and exception handling.

The project is actively being developed, with additional backend features planned as development progresses.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| ☕ Java | Core programming language |
| 🌱 Spring Boot | Backend framework |
| 🔗 Spring Data JPA | Data access & persistence |
| 🗄️ Hibernate | ORM |
| 🐬 MySQL | Relational database |
| 📦 Maven | Dependency management & build |
| 🔌 REST APIs | Client-server communication |
| 🧪 Postman | API testing |

---

## ✨ Current Features

- ✅ Create job applications
- ✅ Retrieve job applications
- ✅ Update job applications
- ✅ Delete job applications
- ✅ MySQL database integration
- ✅ JPA/Hibernate persistence
- ✅ RESTful API endpoints
- ✅ DTO-based request & response handling
- ✅ Service and repository layers
- ✅ Global exception handling

---

## 🏗️ Architecture

The application follows a layered backend architecture:

```text
                 ┌─────────────────┐
                 │     Client      │
                 │    (Postman)    │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │   Controller    │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │     Service     │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │   Repository    │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │      MySQL      │
                 └─────────────────┘
```

---

## 📂 Project Structure

```text
src/
└── main/
    ├── java/
    │   └── com.example.demo/
    │       ├── DemoApplication
    │       ├── JobApplication
    │       ├── JobApplicationController
    │       ├── JobApplicationService
    │       ├── JobApplicationRepository
    │       ├── JobApplicationRequest
    │       ├── JobApplicationResponse
    │       ├── GlobalExceptionHandler
    │       └── ...
    │
    └── resources/
        ├── static/
        ├── templates/
        └── application.properties
```

---

## 🔌 API Operations

The application currently supports the core CRUD operations:

| Method | Operation |
|--------|-----------|
| `GET` | Retrieve job applications |
| `POST` | Create a new job application |
| `PUT` | Update an existing job application |
| `DELETE` | Delete a job application |

API endpoints are tested using **Postman**.

---

## ⚙️ Running Locally

### 1. Clone the repository

```bash
git clone <repository-url>
cd job-application-tracker
```

### 2. Create the database

Create a MySQL database for the application.

### 3. Configure database credentials

Create:

```text
src/main/resources/application.properties
```

using the provided:

```text
application.properties.example
```

Add your local MySQL username and password.

> 🔒 Database credentials are intentionally excluded from version control.

### 4. Run the application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

---

## 🧪 Testing

The REST APIs are tested using **Postman**.

Current testing includes:

- CRUD operations
- Request handling
- Database persistence
- API responses
- Error handling

---

## 📈 Development Roadmap

This project is actively being developed.

### ✅ Completed

- [x] Spring Boot project setup
- [x] REST API fundamentals
- [x] CRUD operations
- [x] MySQL integration
- [x] JPA/Hibernate persistence
- [x] Repository layer
- [x] Service layer
- [x] DTOs
- [x] Global exception handling

### 🚧 Planned

- [ ] Input validation
- [ ] Pagination & sorting
- [ ] Improved error responses
- [ ] Logging
- [ ] Spring Security
- [ ] JWT authentication & authorization
- [ ] API documentation

---

## 🎯 Project Goal

The goal of this project is to build a practical backend application while strengthening skills in **Java, Spring Boot, REST APIs, database management, and backend architecture**.

The project will continue to evolve as additional Spring Boot concepts and production-oriented practices are implemented.

---

## 📌 Status

**🟢 Active Development**

More features and improvements are being added as development progresses.