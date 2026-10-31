# 🎬 Movie Ticket Booking System

A Core Java-based Movie Ticket Booking System developed using Java Collections, JDBC, and MySQL. The application allows users to browse movies, explore theatres by city, view available shows, book seats, and cancel existing bookings through a menu-driven console interface.

## 🎯 Project Overview

The Movie Ticket Booking System is designed to manage basic movie ticket booking operations.

Users can view available movies, select theatres based on city, explore movie shows, and book seats for their preferred show.

The application uses JDBC to connect Java with MySQL and performs database operations using SQL queries, PreparedStatement, and ResultSet.

It also uses Java Collections to manage selected seats and booking information during application execution.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| Java Collections | Managing selected seats and booking data |
| JDBC | Java database connectivity |
| MySQL | Relational database |
| SQL | Database queries and operations |
| IntelliJ IDEA | Development environment |

## ✨ Key Features

### 🎥 Movie Management
- Display available movies.
- Retrieve movie information including title, language, genre, and duration.

### 🏢 Theatre Management
- Search theatres based on city.
- Display theatre IDs and names.

### 🎞️ Show Management
- Display available shows for a selected theatre and movie.
- Retrieve show time, timing, and available seat information.
- Display combined movie, theatre, city, and show details.

### 🎟️ Seat Booking
- Book multiple seats for a selected show.
- Check whether selected seats are already booked.
- Calculate ticket prices based on the number of selected seats.
- Save booking information in MySQL.
- Use database transactions to commit successful bookings or roll back detected booking conflicts.

### ❌ Booking Cancellation
- Cancel an existing booking using its booking ID.
- Release previously booked seats.
- Delete the corresponding booking record from the database.

## 🏗️ Application Architecture

The application follows a simple Java class-based structure.

```text
              MainApp
                 |
                 v
        BookYourMovieSystem
                 |
                 v
          Databaseconfigure
                 |
                 v
              JDBC
                 |
                 v
             MySQL DB
```

### Class Responsibilities

- **MainApp:** Provides the menu-driven console interface and accepts user input.
- **BookYourMovieSystem:** Handles movie display, theatre search, show retrieval, seat booking, and booking cancellation.
- **Databaseconfigure:** Establishes the MySQL database connection using JDBC.
- **Movies:** Represents movie information.
- **Theater:** Represents theatre details.
- **Show:** Represents movie show information.
- **Seat:** Represents seat details and booking status.
- **Booking:** Represents booking information, selected seats, and total price.
- **user:** Represents user information.

## 🔄 Booking Workflow

1. Start the application through the console.
2. Display available movies.
3. Select a city to view available theatres.
4. Select a theatre and movie to view available shows.
5. Enter the user ID and selected show ID.
6. Enter seat numbers to book.
7. Check whether the selected seats are already booked.
8. Calculate the total ticket price.
9. Store the booking information in MySQL.
10. Commit the transaction when booking succeeds.

### Ticket Price Calculation

The application currently uses a fixed ticket price of ₹200 per seat.

**Formula:**

Total Amount = Number of Selected Seats × ₹200

Example:

| Seats | Price per Seat | Total Amount |
|---|---:|---:|
| 1 | ₹200 | ₹200 |
| 2 | ₹200 | ₹400 |
| 3 | ₹200 | ₹600 |
| 4 | ₹200 | ₹800 |

## 🗄️ Database Integration

The application connects to MySQL using JDBC.

### Database Operations

- Establishes database connections using DriverManager.
- Executes SQL queries using Statement and PreparedStatement.
- Retrieves database records using ResultSet.
- Updates seat booking status.
- Inserts and deletes booking records.
- Uses SQL JOIN operations to retrieve combined movie, theatre, and show information.
- Uses database transactions for booking operations.

### Database Tables Used

The source code references the following MySQL tables:

- `Movies`
- `Theaters`
- `Shows`
- `Seat`
- `Bookings`

The database schema must be created separately before running the application.

## 📂 Project Structure

```text
Movie-Ticket-Booking-System/
│
└── bmsbackend/
    │
    ├── MainApp.java
    │
    ├── BookYourMovieSystem.java
    │
    ├── Databaseconfigure.java
    │
    ├── Movies.java
    │
    ├── Theater.java
    │
    ├── Show.java
    │
    ├── Seat.java
    │
    ├── Booking.java
    │
    └── user.java
```

## ⚙️ Getting Started

### Prerequisites

- Java JDK
- MySQL Server
- MySQL Connector/J
- IntelliJ IDEA or another Java IDE

### Installation and Setup

**1. Clone the repository**

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

**2. Open the project**

Open the downloaded project in IntelliJ IDEA.

**3. Configure MySQL**

Create a MySQL database named:

```sql
CREATE DATABASE BOOKYOURTICKET;
```

Create the required tables and configure their columns according to the SQL queries used in the application.

**4. Configure database connectivity**

Update the database connection details in `Databaseconfigure.java`.

Use your own database credentials. Do not commit passwords or other secrets to GitHub.

**5. Add MySQL Connector/J**

Add the MySQL Connector/J library to the project dependencies.

**6. Run the application**

Execute:

```text
MainApp.java
```

The menu-driven booking system will start in the console.

## 📚 Concepts Applied

- Object-Oriented Programming (OOP)
- Java Classes and Objects
- Constructors, Getters and Setters
- Java Collections – List and Arrays
- JDBC Connectivity
- PreparedStatement and ResultSet
- SQL Queries and JOIN Operations
- MySQL Database Integration
- Database Transactions
- Commit and Rollback
- Exception Handling
- Console-Based Application Development

## 👨‍💻 Author

**Sanjay P Achar**

Aspiring Java Developer | Learning Java & Backend Development

- GitHub: [codewithsanjay-hacks](https://github.com/codewithsanjay-hacks)
- LinkedIn: [Sanjay P Achar](https://linkedin.com/in/sanjay-p-achar)

---

⭐ If you find this project useful, consider giving it a star!
