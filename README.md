# Digital Library Book Management System

## Overview
The **Digital Library Book Management System** is a Spring Boot application designed to manage a library's book records. It provides RESTful APIs to add, update, view, and delete books, ensuring efficient management of book availability and details.

## Features
- Add new books to the library.
- Retrieve book details by ID or title.
- Update book information.
- Delete books from the library.
- View all available books.
- Exception handling for invalid requests.
- Actuator endpoint to gracefully shut down the application.

## Tech Stack
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL** (as the database)
- **Lombok** (for reducing boilerplate code)
- **Spring Boot Actuator** (for monitoring and managing the application)
- **Postman** (for API testing)

## Prerequisites
Ensure you have the following installed on your system:
- Java 17+ (JDK)
- MySQL Database Server
- Spring Tool Suite (STS) or Eclipse IDE
- Postman (for API testing)

## Setup Instructions
### 1. Clone the Repository
```sh
$ git clone https://github.com/your-repo/Digital-Library-BMS.git
$ cd Digital-Library-BMS
```

### 2. Configure MySQL Database
Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bmsdb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true

management.endpoint.shutdown.enabled=true
management.endpoints.web.exposure.include=shutdown
```

### 3. Build and Run the Application
#### Using Spring Tool Suite (STS) / Eclipse:
- Open the project in **STS** or **Eclipse**.
- Right-click on the main application class (`DigitalLibraryBookManagementSystemApplication.java`).
- Select **Run As → Spring Boot Application**.

#### Using Command Line:
```sh
$ mvn clean install
$ mvn spring-boot:run
```

## Dependencies
Ensure the following dependencies are included in your `pom.xml` file:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## API Endpoints
All endpoints use `http://localhost:8080/books/`

### Book Management
| Method | Endpoint                    | Description                     |
|--------|-----------------------------|---------------------------------|
| POST   | `/add`                      | Add a new book                 |
| GET    | `/view-all`                 | Retrieve all books              |
| GET    | `/find/id/{bookId}`         | Find book by ID                 |
| GET    | `/find/title/{title}`       | Find book by title              |
| PUT    | `/update/{bookId}`          | Update book details             |
| DELETE | `/delete/{bookId}`          | Delete book by ID               |

### Actuator Endpoint (Shutdown)
| Method | Endpoint                  | Description                   |
|--------|---------------------------|-------------------------------|
| POST   | `/actuator/shutdown`      | Gracefully shut down the app  |

## Testing the APIs
- Use **Postman** to send API requests to `http://localhost:8080/books/`
- Example request to **add a book**:
  - **POST** `http://localhost:8080/books/add`
  - Body (JSON):
    ```json
    {
      "title": "Spring Boot Guide",
      "author": "John Doe",
      "genre": "Technology",
      "status": "AVAILABLE"
    }
    ```

## License
This project is for **Educational purpose**.