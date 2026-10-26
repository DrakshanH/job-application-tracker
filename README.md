# Job Application Tracker API

A RESTful backend application built with **Java and Spring Boot** to manage job applications, featuring CRUD operations, filtering, pagination, sorting, and JWT-based authentication.

## Overview

Job Application Tracker helps users organize and manage their job applications in one place. The backend exposes REST APIs for managing application details and protects application endpoints using Spring Security and JSON Web Tokens (JWT).

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Maven
- **Database:** MySQL
- **Persistence:** Spring Data JPA and Hibernate
- **Security:** Spring Security, BCrypt password hashing, JWT
- **API Testing:** Postman
- **Version Control:** Git and GitHub

## Features

- User registration and login
- Password hashing using BCrypt
- JWT-based authentication
- Protected application endpoints
- Create, read, update, and delete job applications
- Search applications by company or status
- Pagination using page number and page size
- Sorting by application fields in ascending or descending order
- Request validation using Jakarta Bean Validation
- Global exception handling and meaningful HTTP status codes
- Application logging using SLF4J
- Environment-based configuration for database credentials and JWT secrets

## Application Details

Each job application can contain:

- Company name
- Job role
- Application date
- Application status
- Notes

## API Reference

Base URL: `http://localhost:8080`

### Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/register` | Register a user |
| POST | `/auth/login` | Authenticate a user and obtain a JWT |

### Job Applications

| Method | Endpoint | Description |
|---|---|---|
| POST | `/applications` | Create an application |
| GET | `/applications` | Retrieve applications |
| GET | `/applications/{id}` | Retrieve an application by ID |
| PUT | `/applications/{id}` | Update an application |
| DELETE | `/applications/{id}` | Delete an application |
| GET | `/applications/filter?status=APPLIED` | Filter by status |
| GET | `/applications/filter/company?company=Google` | Filter by company |

### Pagination and Sorting

Retrieve the first five applications:

`GET /applications?page=0&size=5`

Sort applications by company name alphabetically:

`GET /applications?sort=company,asc`

Sort by application date, newest first:

`GET /applications?sort=applicationDate,desc`

Combine pagination and sorting:

`GET /applications?page=0&size=2&sort=company,asc`

Page numbering starts at zero. Paginated responses include the requested records and metadata such as total elements and total pages.

## Example Requests

### Register a user

`POST /auth/register`

```json
{
  "username": "your_username",
  "password": "your_password"
}
```

### Log in

`POST /auth/login`

```json
{
  "username": "your_username",
  "password": "your_password"
}
```

Use the JWT returned by the login endpoint in the `Authorization` header for protected requests:

`Authorization: Bearer <your_jwt_token>`

### Create a job application

`POST /applications`

```json
{
  "company": "Google",
  "role": "Software Engineer",
  "applicationDate": "2026-10-25",
  "status": "APPLIED",
  "notes": "Applied through careers page"
}
```

Set the request body type to JSON and include a valid JWT in the authorization header.

## Project Structure

```text
com.example.demo
├── controller
│   ├── AuthController
│   └── JobApplicationController
├── service
│   ├── AuthService
│   ├── JobApplicationService
│   └── JwtService
├── repository
│   ├── UserRepository
│   └── JobApplicationRepository
├── entity
│   ├── User
│   └── JobApplication
├── dto
│   ├── RegisterRequest
│   ├── LoginRequest
│   ├── JobApplicationRequest
│   └── JobApplicationResponse
├── security
│   ├── SecurityConfig
│   ├── JwtAuthenticationFilter
│   └── CustomUserDetailsService
└── exception
    ├── ApplicationNotFoundException
    └── GlobalExceptionHandler
```

## Setup and Configuration

### Prerequisites

- Java 17 or later
- MySQL
- Git

### 1. Clone the repository

```bash
git clone https://github.com/DrakshanH/job-application-tracker.git
cd job-application-tracker
```

### 2. Create the database

Run the following SQL command in MySQL:

```sql
CREATE DATABASE taskdb;
```

### 3. Configure environment variables

Configure the following variables in your IDE's run configuration or your local environment:

```text
DB_URL=jdbc:mysql://localhost:3306/taskdb
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
JWT_SECRET=your_unique_random_secret
```

Use a strong, randomly generated JWT secret of at least 32 bytes for the current HMAC configuration.

Do not commit actual credentials or secrets to version control.

### 4. Run the application

On Windows, use the Maven wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, run `DemoApplication` from your IDE.

The API will be available at `http://localhost:8080` when the application starts successfully.

## Implementation Concepts

This project demonstrates practical backend development concepts, including:

- Layered architecture using controllers, services, and repositories
- Dependency injection through constructors
- RESTful API design and HTTP methods
- Object-relational mapping with JPA and Hibernate
- DTO-based request and response handling
- Validation and centralized exception handling
- Password hashing and JWT authentication
- Database filtering, pagination, and sorting
- Logging and environment-based configuration

## Future Improvements

- Automated unit and integration tests
- Frontend integration using React
- Deployment and containerization
- Additional application search and reporting features
