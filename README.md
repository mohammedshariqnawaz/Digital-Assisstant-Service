# Digital Assistant Service

## Overview

The **Digital Assistant Service** is a RESTful API built with **Spring Boot** that allows users to create and send messages to the created digital assistants.
Each assistant has a unique name and a predefined response, enabling seamless interactions.
The service incorporates validation and global exception handling to ensure data integrity and provide consistent error responses.

## Features

- **Operations:** Create and Read digital assistants.
- **Validation:** Ensures data integrity with input validation for request bodies and parameters.
- **Global Exception Handling:** Provides consistent and informative error responses across all endpoints.
- **API Documentation:** Interactive API docs powered by **Swagger UI** for easy exploration and testing.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Validation**
- **SpringDoc OpenAPI (Swagger)**
- **Maven**

## Prerequisites

- **Java 23** or higher installed.
- **Maven** installed.
- An **IDE** (e.g., IntelliJ IDEA, Eclipse) for development and running the application.


## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/mohammedshariqnawaz/Digital-Assisstant-Service.git
   ```
2. Running the Application(Using an IDE)
   - Import the Project
   - Locate the `DigitalAssistantServiceApplication` main class.
   - Build and Run the Project:
    ```bash
    mvn clean install
   mvn spring-boot:run
    ```
3. **Accessing the Application**

   Interactive API documentation is available via Swagger UI to explore the API endpoints directly from your browser.
   http://localhost:8080/swagger-ui/index.html

## API Endpoints
The application runs on http://localhost:8080. Below are the available endpoints:

1.   **Create a New Assistant**

* **Endpoint:** `POST /api/assistant`
* **Description:** Adds a new digital assistant.
* **Request Body:**`{
"name": "JouleAssistant",
"response": "Hello! How can I assist you today?"
}`
* Responses:
  * **201 Created**: Assistant defined successfully.
  * **409 Conflict**: Assistant with the given name already exists.
  * **400 Bad Request**: Validation errors.

2. Send a Message to a Digital Assistant
* **Endpoint:** ` POST /api/assistant/{name}/messages`
* **Description:** Sends a message to the specified assistant and retrieves its predefined response.
* **Path Parameters:** `name` (String): The unique name of the assistant.
* **Request Body:**`"Hi there!"`
* Responses:
  * **200 OK**: Returns the assistant's predefined response
  * **404 Not Found**: Assistant with the given name does not exist.
  * **400 Bad Request:** Validation errors.

## Future Enhancements
While the current implementation covers the core functionalities, here are some potential enhancements :

* Persistence Layer: Integrate a persistent database (e.g., PostgreSQL, MySQL) to store digital assistants.
* Security: Implement authentication and authorization mechanisms to secure API endpoints.
* Logging: Incorporate a robust logging framework for better monitoring and debugging.
* Rate Limiting: Prevent abuse by limiting the number of requests a client can make in a given timeframe.
* Pagination and Sorting: Optimize endpoints that return large datasets by implementing pagination and sorting.
* Deployment: Deploy the application to a cloud platform for wider accessibility.