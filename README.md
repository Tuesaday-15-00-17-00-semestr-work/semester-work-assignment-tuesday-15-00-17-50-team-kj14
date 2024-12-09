# Library Management System

## Description

This project is a web application for managing a simple library system. It allows users to browse books, and administrators to manage users and books within the system. The application uses Spring Boot, Spring Security, Spring Data JPA, FreeMarker, and MySQL.

## Features

-   **User Authentication:**
    -   Users can register and log in.
    -   Different user roles (ROLE\_USER, ROLE\_ADMIN).
-   **Book Management:**
    -   List all books.
    -   Search books by title.
    -   View book details (title, author, ISBN, availability).
    -   Add new books (with transaction logging).
    -   Take (borrow) books (with transaction logging).
    -   Delete books.
-   **Admin Panel:**
    -   Manage users (view, ban/unban).
    -   Edit user roles.
-   **Transaction Logging:**
    -   Records all book addition, taking, and deletion actions with timestamps and associated user.

## Technologies Used

-   **Java 17:** Programming language.
-   **Spring Boot 3.3.5:** Framework for building the application.
-   **Spring Security:** For authentication and authorization.
-   **Spring Data JPA:** For database interaction.
-   **FreeMarker:** Templating engine for generating views.
-   **MySQL:** Database to store users, books, and transactions.
-   **Maven:** Build tool.
-   **Lombok:** For reducing boilerplate code.

## Project Structure

-   **`src/main/java/com/example/library`:** Contains the Java source code.
    -   **`CommandLineRunner`:** Initializes the database with an admin user on startup.
    -   **`configurations`:** Security configuration.
    -   **`controllers`:** Web controllers for handling requests.
    -   **`models`:** Domain objects (Book, User, Transaction).
    -   **`enums`:** Enumerations for `Role` and `ActionType`.
    -   **`repositories`:** Spring Data JPA repositories for database access.
    -   **`services`:** Business logic for managing users, books, and transactions.
-   **`src/main/resources`:**
    -   **`templates`:** FreeMarker templates for the views.
    -   **`application.properties`:** Application configuration (database connection, etc.).

## Getting Started

### Prerequisites

1. **Java 17 JDK:** Ensure you have Java 17 installed.
2. **MySQL:** Install and run a MySQL server.
3. **Maven:** Make sure you have Maven installed for building the project.

### Setup

1. **Database Configuration:**
    -   Create a MySQL database named `library`.
    -   Update the `application.properties` file with your MySQL username and password:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/library
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    ```

2. **Build the Project:**
    -   Open a terminal in the project's root directory.
    -   Run the following Maven command:

    ```bash
    mvn clean install
    ```

3. **Run the Application:**
    -   Execute the following command:

    ```bash
    mvn spring-boot:run
    ```

    -   Alternatively, you can run the `LibraryApplication` class from your IDE.

4. **Access the Application:**
    -   Open your web browser and go to: `http://localhost:8080`

## Usage

### Initial Login

-   The application automatically creates an admin user on the first run:
    -   **Email:** `admin@admin.com`
    -   **Password:** `admin`

### User Roles

-   **ROLE\_ADMIN:**
    -   Can access the admin panel (`/admin`).
    -   Can manage users and books.
-   **ROLE\_USER:**
    -   Can browse and search books.
    -   Can take (borrow) books.

### Admin Panel

-   Access the admin panel at `/admin`.
-   **User Management:**
    -   View a list of all users.
    -   Ban or unban users.
    -   Edit user roles.

### Book Management

-   **Home Page (`/`):**
    -   View a list of all books.
    -   Search for books by title.
-   **Book Details (`/books/{id}`):**
    -   View details of a specific book.
-   **Add Book (`/books/create`):**
    -   Add a new book to the library (requires admin privileges).
-   **Take Book (`/books/take/{id}`):**
    -   Borrow a book (if available).
-   **Delete Book (`/books/delete/{id}`):**
    -   Delete a book (requires admin privileges).

## Contributing

If you would like to contribute to this project, please feel free to submit a pull request or open an issue.

## License

This project is licensed under the [Your License Name] License - see the `LICENSE` file for details.
