# Library System

A library management system built in plain Java, running through the console. It supports adding, listing, borrowing, returning and removing books, with data validation and handling of the main error cases.

This project was built step by step as part of my Java learning process, starting from the basics of classes and objects and evolving into a more organized structure split into layers.

## Technologies

- Java
- Git / GitHub

## Concepts applied

- Object-Oriented Programming (classes and objects)
- Encapsulation (private fields, getters and setters)
- Constructors
- Static field (used to auto-generate each book's ID)
- ArrayList, to store the list of books
- Loops (for, for-each, do-while)
- Conditionals (if/else, switch)
- Reading user input with Scanner
- Code organized into packages

## Project structure

```
system_of_library
 ├── model
 │    └── Book.java       -> represents a book (data and validation)
 ├── service
 │    └── Library.java    -> holds the list of books and the business logic
 └── interection
      └── Choice.java     -> menu and user input handling
```

The idea behind this split is to separate responsibilities: `Book` only deals with a single book's data, `Library` manages the collection (adding, listing, borrowing, etc.), and `Choice` only handles interaction with whoever is using the program. This keeps each class with a clear purpose, and makes it easier to change one part without breaking the others.

## Features

- Add a book
- List registered books
- Borrow a book (by ID)
- Return a book (by ID)
- Remove a book (by ID)

Each book gets a unique ID automatically when it's registered, used to find it in the other operations.

The program also handles some common errors, like trying to borrow a book that's already borrowed, entering an ID that doesn't exist, or trying to return a book that wasn't borrowed.

## How to run

1. Clone the repository:
```
git clone https://github.com/NicolasGoulart18/SistemOfLibrary.git
```
2. Open the project in your IDE of choice.
3. Run the `Choice.java` class (it contains the `main` method).
4. Use the console menu to navigate through the options.

## Usage example

```
=======  MENU  =======
Choose an option:
[1] Add Book
[2] List Books
[3] Borrow Book
[4] Return Book
[5] Remove Book
[6] Exit
```

## Next steps

I still plan to evolve this project with:

- Exception handling
- File-based data persistence
- Database integration (JDBC / MySQL)
- Migration to Spring Boot
- REST API

## Author

Nicolas Goulart