Overview
This project is a Spring Boot application for managing ticket vending operations. It includes endpoints for handling requests, storing ticket data, and processing ticket-related logic.

Project Structure
src/main/java
com.example.demo22
controller
TicketVendingController:
Handles incoming HTTP requests and maps them to appropriate service methods.

entity
TicketVendingRequestEntity:
Represents the database entity for ticket vending requests.

model
request
TicketVendingRequest: 
Model for incoming ticket vending requests.
response
Ticket:
Model for outgoing ticket details.


repository
TicketVendingRequestRepository:
Handles database operations for ticket vending requests.
service
TicketVendingService: 
Contains the business logic for processing ticket vending operations.


treading
Demo22Application:
The main application class used to start the Spring Boot application.
src/main/resources
application.properties: 
Configuration file for defining application-specific properties such as database connections.
banner.txt: 
Optional banner displayed in the console when the application starts.
src/test
Contains unit and integration tests for the application.

How to Run
Clone the Repository bash Copy code   git clone <repository-url>
cd demo22

Set Up Dependencies Ensure you have Maven installed. Use the following command to download dependencies:  Copy code   mvn clean install

Configure Database Update the application.properties file in src/main/resources with your database configurations.
Run the Application Start the application using the following Maven command: arduino Copy code   mvn spring-boot:run
Alternatively, run Demo22Application.java from your IDE.
Access the API
Default base URL: http://localhost:8080
Example Endpoints:
POST /tickets - Request a new ticket.
GET /tickets/{id} - Fetch ticket details.

Key Files
TicketVendingController.java: Manages all API requests.
TicketVendingService.java: Implements business logic for ticket vending.
TicketVendingRequestRepository.java: Interface for database operations.

Dependencies
This project uses the following major dependencies:
Spring Boot Starter Web
Spring Boot Starter Data JPA
H2/PostgreSQL/MySQL (Update application.properties accordingly)
Maven for build automation

Contact
For questions or issues, contact Pasan.20232191@iit.ac.lk 