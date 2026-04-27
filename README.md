Airbnb Java CRUD App

A simple desktop application built using Java Swing, JDBC, and MySQL. The application allows users to perform basic CRUD (Create, Read, Update, Delete) operations on Airbnb-style listings.

Features

* Add listing
* View listings
* Update listing
* Delete listing
* Simple graphical user interface using Swing


Tech Stack

* Java (Swing for GUI)
* JDBC (Database connectivity)
* MySQL (Database)
* Eclipse IDE



Project Structure

AirbnbApp/
  ├── src/
  │   ├── db/
  │   ├── model/
  │   ├── dao/
  │   ├── ui/
  │   └── Main.java



Database Setup

Create the database and table using the following SQL:
CREATE DATABASE airbnb_db;

USE airbnb_db;

CREATE TABLE listings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    location VARCHAR(100),
    price DOUBLE
);


Setup Instructions

1. Clone the repository:
git clone https://github.com/yourusername/Airbnb-Java-App.git

2. Open the project in Eclipse.

3. Add MySQL Connector JAR to the project.

4. Update database credentials in DBConnection.java.

5. Run Main.java.


Notes

* Make sure MySQL is running before starting the application.
* Ensure correct username and password are set in the database connection file.


Author

Shreyas R
