# 💼 Job Application Tracker

A RESTful backend application built with **Java and Spring Boot** to manage job applications, with user registration, login, and JWT-based authentication.

## 🚀 About the Project

Job Application Tracker is a backend application designed to help organize job applications in one place.

The project follows a layered architecture and explores practical backend development concepts, including REST APIs, service-layer design, database persistence, DTOs, exception handling, and authentication using Spring Security and JSON Web Tokens (JWT).

The project is actively being developed, with additional backend features planned as development progresses.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| ☕ Java | Core programming language |
| 🌱 Spring Boot | Backend framework |
| 🔐 Spring Security | Application security and authentication |
| 🎟️ JJWT | JWT creation and validation |
| 🔗 Spring Data JPA | Data access and persistence |
| 🗄️ Hibernate | Object-relational mapping (ORM) |
| 🐬 MySQL | Relational database |
| 📦 Maven | Dependency management and build |
| 🔌 REST APIs | Client-server communication |
| 🧪 Postman | API testing |

## ✨ Current Features

### Job Application Management
- Create job applications
- Retrieve job applications
- Update existing job applications
- Delete job applications
- Persist data using MySQL, JPA, and Hibernate
- Use DTOs for request and response handling
- Separate controller, service, and repository layers
- Handle exceptions globally

### Authentication and Security
- User registration endpoint
- User login endpoint
- JWT service for token-related operations
- JWT authentication filter
- Spring Security configuration
- User persistence and repository layer
- Custom user-details service

> Authentication flows and endpoint access rules should be verified through integration testing before considering the security implementation fully validated.

## 🏗️ Architecture

The application uses a layered backend architecture:

```text
                   Client (Postman)
                          |
                          v
                Controller Layer
                          |
                          v
                  Service Layer
                          |
                          v
                Repository Layer
                          |
                          v
                    MySQL DB
```

Spring Security and the JWT authentication filter participate in processing secured HTTP requests before they reach the application controllers.

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── DemoApplication.java
│   │   ├── JobApplication.java
│   │   ├── JobApplicationController.java
│   │   ├── JobApplicationService.java
│   │   ├── JobApplicationRepository.java
│   │   ├── JobApplicationRequest.java
│   │   ├── JobApplicationResponse.java
│   │   ├── ApplicationNotFoundException.java
│   │   ├── GlobalExceptionHandler.java
│   │   ├── AuthController.java
│   │   ├── AuthService.java
│   │   ├── CustomUserDetailsService.java
│   │   ├── JwtAuthenticationFilter.java
│   │   ├── JwtService.java
│   │   ├── LoginRequest.java
│   │   ├── RegisterRequest.java
│   │   ├── SecurityConfig.java
│   │   ├── User.java
│   │   └── UserRepository.java
│   └── resources/
│       └── application.properties.example
└── test/
    └── resources/
        └── application.properties
```

The test resources configure an in-memory H2 database for automated tests. The application uses MySQL for local development.

## 🔌 API Operations

### Job Applications

| Method | Operation |
|---|---|
| `GET` | Retrieve job applications |
| `POST` | Create a job application |
| `PUT` | Update a job application |
| `DELETE` | Delete a job application |

### Authentication

| Operation | Purpose |
|---|---|
| Registration | Create a user account |
| Login | Authenticate a user and obtain a JWT, if configured by the implementation |

The exact endpoint paths, request formats, and authentication requirements are defined by the controller and Spring Security configuration.

API requests can be tested using Postman.

## ⚙️ Running Locally

### 1. Clone the repository

```bash
git clone https://github.com/DrakshanH/job-application-tracker.git
cd job-application-tracker
```

### 2. Create the MySQL database

Create the database configured for the application. For the current local setup, the database name is `job_application`.

### 3. Configure application properties

Create a local file at:

`src/main/resources/application.properties`

Use `src/main/resources/application.properties.example` as a reference and configure your own database URL, username, and password.

Configure any JWT signing secret required by the application using the configuration expected by `JwtService`. Use a strong, private value and never commit real secrets.

**Database credentials and signing secrets must remain out of version control.**

### 4. Run the application

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Make sure MySQL is running and the database configuration is correct before starting the application.

## 🧪 Testing

Run the automated test suite using Maven:

```powershell
.\mvnw.cmd clean test
```

The test suite uses an in-memory H2 database configuration so tests do not need to connect to the local MySQL instance.

Postman can be used for manual API testing, including:

- Job application CRUD operations
- Request and response handling
- Database persistence
- Error handling
- User registration and login
- JWT-protected requests and unauthorized access scenarios

## 📈 Development Roadmap

### ✅ Implemented
- Spring Boot project setup
- REST API fundamentals and CRUD operations
- MySQL integration
- JPA/Hibernate persistence
- Repository and service layers
- DTO-based request and response handling
- Global exception handling
- Spring Security integration
- JWT-related authentication components
- Automated test configuration using H2

### 🚧 Planned / To Verify
- Input validation
- Pagination and sorting
- Consistent error response formats
- Structured logging
- End-to-end authentication and authorization testing
- API documentation
- Further security hardening

## 🎯 Project Goal

The goal of this project is to build a practical backend application while strengthening skills in Java, Spring Boot, REST APIs, database management, security, and backend architecture.

## 📌 Status

**Active Development**

The application is being expanded incrementally as additional backend features and production-oriented practices are implemented.
