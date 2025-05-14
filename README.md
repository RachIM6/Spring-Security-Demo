# Spring Security JWT Demo

A demonstration project showcasing Spring Security with JWT authentication for stateless security implementation. This project is designed for educational purposes to help understand core Spring Security concepts.

## Technologies Used

- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- JWT (JSON Web Tokens)
- H2 Database
- Java 17
- Maven

## Dependencies

```xml
<!-- Spring Boot -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- Test -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
</dependency>
```

## Features

- User registration and authentication
- JWT token generation and validation
- Role-based authorization
- Stateless authentication
- RESTful API endpoints

## Project Structure

```
spring-security-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── securitydemo/
│   │   │               ├── SecurityDemoApplication.java
│   │   │               ├── config/
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   └── JwtAuthenticationFilter.java
│   │   │               ├── controller/
│   │   │               │   ├── AuthController.java
│   │   │               │   ├── UserController.java
│   │   │               │   └── AdminController.java
│   │   │               ├── model/
│   │   │               │   ├── User.java
│   │   │               │   └── Role.java
│   │   │               ├── dto/
│   │   │               │   └── LoginRequest.java
│   │   │               ├── repository/
│   │   │               │   ├── UserRepository.java
│   │   │               │   └── RoleRepository.java
│   │   │               └── service/
│   │   │                   └── UserService.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── data.sql
```

## Setup Instructions

### Prerequisites
- JDK 17 or higher
- Maven 3.6+ or use the included Maven wrapper
- IntelliJ IDEA (recommended) or any Java IDE

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/spring-security-demo.git
cd spring-security-demo
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

Or run directly from your IDE by executing the `SecurityDemoApplication` class.

### Default Configuration

The application runs on `http://localhost:8080` by default.

## API Endpoints

### Public Endpoints

- `POST /register` - Register a new user
- `POST /auth/login` - Authenticate and receive JWT token

### Protected Endpoints

- `GET /api/user/info` - Get current user information (requires authentication)
- `GET api/admin/dashboard` - Admin dashboard (requires ADMIN role)

## Usage Examples

### Register a new user

```bash
curl -X POST http://localhost:8080/register \
  -H "Content-Type: application/json" \
  -d '{"username":"newuser", "password":"password123"}'
```

### Login to get JWT token

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"newuser", "password":"password123"}'
```

### Access protected endpoint with JWT token

```bash
curl -X GET http://localhost:8080/api/user/info \
  -H "Authorization: Bearer <your_jwt_token>"
```

### Access admin endpoint (requires ADMIN role)

```bash
curl -X GET http://localhost:8080/admin/dashboard \
  -H "Authorization: Bearer <your_jwt_token>"
```

## Default Users

The application comes with two pre-configured users:

1. Regular User:
    - Username: `user`
    - Password: `user123`
    - Roles: `ROLE_USER`

2. Admin User:
    - Username: `admin`
    - Password: `admin123`
    - Roles: `ROLE_USER`, `ROLE_ADMIN`

## Security Architecture

### Authentication Flow

1. Client submits credentials to `/auth/login`
2. Spring Security validates credentials
3. JWT token is generated and returned to client
4. Client includes JWT in subsequent requests as Bearer token
5. `JwtAuthenticationFilter` extracts and validates the token
6. Security context is populated if token is valid

### JWT Configuration

- Token validity: 1 hour
- Signing algorithm: HMAC SHA-256

## Database Configuration

The project uses an H2 in-memory database for demonstration purposes:

- Console URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (empty)

## Contributing

This project is for educational purposes. Feel free to fork and modify as needed for your own learning.

## License

This project is available under the MIT License.