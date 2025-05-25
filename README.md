student-detail-crud
This project provides a RESTful API for managing student records using Spring Boot.

Overview The StudentController class handles HTTP requests for student-related operations such as creating, reading, updating, and deleting student data.

Base URL /api/v1

Endpoints HTTP Method Endpoint Description Request Body Response GET /students Retrieve all students None List of all students GET /student/{Id} Retrieve a student by their ID None Student object POST /create-student Create a new student record Student JSON object Created Student object DELETE /delete-student/{Id} Delete a student by their ID None Success message PUT /update-student/{id} Update an existing student by ID Student JSON object Updated Student object

Technologies Used Java 11+

Spring Boot

Spring Data JPA (via StudentRepository)

REST API principles

Usage Retrieve all students

bash Copy Edit GET /api/v1/students Get student by ID

bash Copy Edit GET /api/v1/student/{Id} Create a student

bash Copy Edit POST /api/v1/create-student Content-Type: application/json

{ "name": "John Doe", "age": 21, "course": "Computer Science" } Delete student by ID

bash Copy Edit DELETE /api/v1/delete-student/{Id} Update student by ID

bash Copy Edit PUT /api/v1/update-student/{id} Content-Type: application/json

{ "name": "Jane Doe", "age": 22, "course": "Mathematics" } Notes The controller delegates all business logic to StudentDataService.

The StudentRepository is used for data persistence.

All responses use appropriate HTTP status codes (e.g., 200 OK, 201 Created).

Proper error handling should be implemented in StudentDataService (not shown here).

How to Run Ensure you have Java and Maven installed.

Build and run the Spring Boot application:

arduino Copy Edit mvn spring-boot:run API will be accessible at http://localhost:8080/api/v1
