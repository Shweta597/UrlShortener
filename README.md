# UrlShortener

URL Shortener Application
This is a simple URL shortener application built with Spring Boot, Spring MVC, and Spring Data JPA. The application enables users to shorten long URLs and track the number of visits for each shortened link.

Features
URL Shortening: Take any long URL and generate a shortened version.

URL Redirection: Redirect users to the original URL when they visit the shortened link.

Visit Tracking: Keep track of how many times a shortened URL has been visited.

Database Integration: All URLs and related data (short code, visit count, etc.) are stored in a PostgreSQL database using Spring Data JPA.

Technologies Used
Spring Boot: For building the application.

Spring MVC: For handling web requests and rendering views.

Spring Data JPA: For database interactions and ORM.

PostgreSQL: As the database to store URL data.

Thymeleaf: For rendering the frontend view to the user.

Setup and Installation
Clone the repository:

bash
Copy
Edit
git clone https://github.com/Shweta597/UrlShortener.git
cd UrlShortener
Set up the PostgreSQL database and update application.properties with the database credentials:

properties
Copy
Edit
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
Build the application using Maven:

bash
Copy
Edit
./mvnw clean install
Run the application:

bash
Copy
Edit
./mvnw spring-boot:run
The application will be available at http://localhost:8080.

Usage
Navigate to the homepage at http://localhost:8080.

Enter the long URL you want to shorten in the input field.

After submitting, you will receive a shortened URL that redirects to the original URL.

You can visit the shortened URL to be redirected to the original one.

Contributing
Feel free to fork the repository, create pull requests, or open issues for improvements.

License
This project is licensed under the MIT License - see the LICENSE file for details.

