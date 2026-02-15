# Blogging Platform API

This is a robust RESTful API built with **Spring Boot 3**, developed as a solution for the [Blogging Platform API challenge](https://roadmap.sh/projects/blogging-platform-api) from **roadmap.sh**.
The project implements full CRUD operations, advanced wildcard searching, and follows industry-standard REST conventions for status codes and error handling.
## Project Goals
This project was developed to satisfy the technical requirements from roadmap.sh:
- **CRUD Implementation**: Create, Read, Update, and Delete blog posts.
- **REST Best Practices**: Proper use of HTTP methods and Status Codes.
- **Profile-based Configuration**: Seamless switching between H2 (Test) and MySQL (Dev).
- **Search & Filter**: Wildcard query logic across Title, Content, and Category fields.
- **Global Exception Handling**: Standardized error responses for API consumers.
## Tech Stack
- **Language**: Java 21
- **Framework**: Spring Boot 3.4
- **Database**: H2 Database (In-Memory) and MySQL (Persistent)
- **Persistence**: Spring Data JPA / Hibernate
- **Mapping**: MapStruct (Entity/DTO conversion)
- **Validation**: Jakarta Bean Validation (Hibernate Validator)
---
## Getting Started
### Prerequisites
- Java 21 or higher.
- Maven 3.6+.
- MySQL (Optional, required only for the dev profile).
### Environment Profiles

The application supports two distinct environments:

**1. Test Profile (Default / H2)** Runs with an in-memory database. No setup required. Best for quick demos.
- H2 Console: http://localhost:8080/h2-console

**2. Dev Profile (MySQL)** Runs with a persistent MySQL database.
- Setup: Create a database named blogging in your MySQL instance.
- Configuration: 
  - Chance the **spring.profiles.active=test** to **spring.profiles.active=dev** in **src/main/resources/application-dev.properties**
  - Update **src/main/resources/application-dev.properties** with your credentials.
---
## API Endpoints

**POST /posts**
- **Description**: Creates a new blog post.
- **Success Status**: 201 Created.

**GET /posts**
- **Description**: Retrieves all posts. Supports filtering via query parameters.
- **Success Status**: 200 OK.

**GET /posts/{id}**
- **Description**: Retrieves a single post by its unique ID.
- **Success Status**: 200 OK.

**PUT /posts/{id}**
- **Description**: Updates an existing post with new data.
- **Success Status**: 200 OK.

**DELETE /posts/{id}**
- **Description**: Deletes an existing post and its associated tags.
- **Success Status**: 204 No Content.
### Search Functionality

The API allows filtering posts using a term query parameter. It performs a case-insensitive search across **title**, **content**, and **category**.

**Example**: /posts?term=tech

---
## Usage Examples

### Create a Post

**POST** /posts

```bash
{ 
	"title": "My First Blog Post", 
	"content": "This is the content of my first blog post.",
	"category": "Technology", 
	"tags": ["Tech", "Programming"] 
}
```

### Successful Response (201 Created)

```bash
{ 
	"id": 1, 
	"title": "My First Blog Post", 
	"content": "This is the content of my first blog post.", 
	"category": "Technology", 
	"tags": ["Tech", "Programming"], 
	"createdAt": "2026-02-14T06:55:00Z", 
	"updatedAt": "2026-02-14T06:55:00Z" 
}
```

---
## Validation & Error Handling
The API includes a **Global Exception Handler** to ensure consistent error messaging across all endpoints:
- **400 Bad Request**: Returned when the request body fails validation (e.g., title too short or missing fields).
- **404 Not Found**: Returned when the requested Post ID does not exist in the database.
- **422 Unprocessable Entity**: Returned for semantic errors or business rule violations.
---
## Note on MapStruct

This project uses **MapStruct** for type-safe bean mapping.
- **Compilation**: You must run the Maven install command to generate the Mapper implementation classes located in the target/generated-sources folder.
- **IDE Setup**: Ensure **Annotation Processing** is enabled in your IDE (IntelliJ IDEA or Eclipse) settings to recognize the generated classes during development.

---
## Credits

Project idea and requirements provided by [roadmap.sh](https://roadmap.sh/projects/blogging-platform-api).