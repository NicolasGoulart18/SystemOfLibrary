# Library System

A library management system built in Java and developed as a study project focused on Object-Oriented Programming.

The project started as a simple console application and evolved throughout development, incorporating inheritance, polymorphism, encapsulation, enums, business rules, user roles and a more organized project structure.

## Technologies

* Java
* Git / GitHub
* Java HTTP Server

## Concepts Applied

* Object-Oriented Programming
* Encapsulation
* Inheritance
* Polymorphism
* Constructors
* Method overriding with `@Override`
* `ArrayList`
* Enums
* Composition
* `instanceof` and pattern matching
* Loops and conditionals
* `Scanner` for user input
* Exception handling
* Separation of responsibilities
* Business rules
* Code organization with packages

## Project Structure

```text
system_of_library
├── emprestimo
│   ├── Emprestimo.java
│   ├── ResultadoEmpr.java
│   ├── ResultadoDevolucao.java
│   └── ResultRemove.java
│
├── interaction
│   ├── Choice.java
│   └── WebServer.java
│
├── model
│   └── Book.java
│
├── service
│   └── Library.java
│
└── usuarios
    ├── Usuario.java
    ├── Aluno.java
    ├── Professor.java
    └── Bibliotecario.java
```

Each package has a specific responsibility:

* `model` contains the main domain entities.
* `service` contains the library management and business logic.
* `usuarios` contains the user hierarchy and different user roles.
* `emprestimo` contains loan-related classes and operation results.
* `interaction` contains the application interface and interaction logic.

## Features

### User Management

The system supports different types of users:

* Student
* Professor
* Librarian

Users are created dynamically and the active user is maintained during the session.

The system also allows the user to switch accounts without restarting the application.

### Book Management

* Add books
* List registered books
* Remove books
* Automatically generate book IDs
* Check book availability

Only librarians are allowed to add or remove books.

### Book Loans

Users can borrow available books using their IDs.

The system validates:

* Whether the book exists
* Whether the book is available
* Whether the loan operation was successful

Each user type has its own loan period, demonstrating polymorphism.

After a successful loan, the system displays the user's deadline for returning the book.

### Book Returns

Users can return books by ID.

The system handles different return results, including:

* Successful return
* Book already returned
* Book not found

### Business Rules

The project contains rules to prevent invalid operations, such as:

* Borrowing an unavailable book
* Removing a book that is currently borrowed
* Adding or removing books without librarian permissions
* Operating with a book ID that does not exist

Operation results are represented using enums instead of relying only on boolean values.

## Error Handling

The application handles invalid numeric input using exception handling and provides feedback when an invalid option or value is entered.

## Web Server

The project also contains an experimental HTTP server implementation using Java's built-in HTTP server.

It provides a simple web interface for interacting with the library and demonstrates how the existing Java business logic can be exposed through HTTP endpoints.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/NicolasGoulart18/SystemOfLibrary.git
```

2. Open the project in an IDE that supports Java.

3. Run:

```text
system_of_library.interaction.Choice
```

4. Follow the instructions displayed in the console.

## What I Learned

This project was initially created to review Java and Object-Oriented Programming concepts.

Throughout its development, I practiced not only writing code, but also refactoring an existing project and improving its architecture as new requirements appeared.

Some of the main topics practiced were:

* Designing classes and relationships
* Applying inheritance and polymorphism
* Separating responsibilities
* Modeling business rules
* Using enums to represent operation results
* Organizing a Java project into packages
* Refactoring large methods
* Using Git and GitHub throughout development

## Author

Nicolas Goulart
