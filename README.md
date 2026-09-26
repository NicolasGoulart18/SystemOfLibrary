# Library System

Library management system developed in Java as a study project focused on Object-Oriented Programming, business rules, and code organization.

The project started as a simple console application and gradually evolved with user roles, loans, returns, enums, validations, and an experimental HTTP interface.

## Main Features

### User management

The system supports different user types:

- Student
- Professor
- Librarian

The active user can be changed during the same application session.

### Book management

- Add books
- List registered books
- Remove eligible books
- Generate book IDs
- Check availability

Book creation and removal are restricted to librarian users.

### Loans

Users can borrow available books by ID.

The system validates whether:

- The book exists
- The book is available
- The loan can be completed

Different user types can have different loan periods, applying polymorphism to the business rules.

### Returns

Books can be returned by ID, with specific operation results for cases such as:

- Successful return
- Book already returned
- Book not found

## Business Rules

The project prevents invalid operations such as:

- Borrowing an unavailable book
- Removing a borrowed book
- Adding or removing books without librarian permission
- Operating with a book ID that does not exist

Enums are used to represent operation results instead of relying only on boolean values.

## Concepts Applied

- Object-Oriented Programming
- Encapsulation
- Inheritance
- Polymorphism
- Constructors
- Method overriding
- Composition
- `ArrayList`
- Enums
- `instanceof` and pattern matching
- Loops and conditionals
- `Scanner`
- Exception handling
- Separation of responsibilities
- Business rules
- Package organization

## Project Structure

```text
system_of_library
├── emprestimo
│   ├── Emprestimo.java
│   ├── ResultadoEmpr.java
│   ├── ResultadoDevolucao.java
│   └── ResultRemove.java
├── interaction
│   ├── Choice.java
│   └── WebServer.java
├── model
│   └── Book.java
├── service
│   └── Library.java
└── usuarios
    ├── Usuario.java
    ├── Aluno.java
    ├── Professor.java
    └── Bibliotecario.java
```

### Package responsibilities

- `model` — domain entities
- `service` — library management and business logic
- `usuarios` — user hierarchy and roles
- `emprestimo` — loan-related classes and operation results
- `interaction` — console and HTTP interaction layers

## CRUD Overview

The basic CRUD flow is centered on books:

- **Create:** register books
- **Read:** list and inspect the catalog
- **Update:** change book state through loans and returns
- **Delete:** remove eligible books

## Error Handling

Invalid numeric input is handled with exceptions, and the application provides feedback when the user enters an invalid option or value.

## Experimental Web Server

The repository also contains an experimental HTTP server built with Java's native HTTP server.

Its purpose is to explore how the existing business logic can be exposed through HTTP without changing the core domain rules.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/NicolasGoulart18/SystemOfLibrary.git
```

2. Open the project in a Java IDE.
3. Run:

```text
system_of_library.interaction.Choice
```

4. Follow the menu displayed in the terminal.

## What I Learned

This project has been used to practice both implementation and refactoring.

Main learning points:

- Designing classes and relationships
- Applying inheritance and polymorphism
- Separating responsibilities
- Modeling business rules
- Using enums for operation results
- Organizing packages
- Refactoring methods as requirements evolve
- Using Git and GitHub during development

## Project Goal

The goal is to practice Java and object-oriented design through a complete library flow while keeping the code understandable enough to study and evolve.

## Author

Nicolas Goulart
