# Pharmacy Management System

A desktop-based Pharmacy Management System developed using **Java Swing**, **JDBC**, **MySQL**, and **Maven**. This application helps manage medicines, customers, billing, and sales through a simple graphical user interface.

## Features

- Secure Login
- Dashboard with statistics
- Medicine Management
  - Add Medicine
  - Update Medicine
  - Delete Medicine
  - View Medicines
- Customer Management
  - Add Customer
  - Update Customer
  - Delete Customer
  - View Customers
- Billing System
- Sales History
- MySQL Database Integration
- Dashboard showing:
  - Total Medicines
  - Total Customers
  - Total Bills
  - Total Sales

## Technologies Used

- Java
- Java Swing
- JDBC
- MySQL
- Maven
- NetBeans IDE

## Database

Database Name:

```
pharmacy_db
```

Tables:

- admin
- medicines
- customers
- sales
- sale_items

## Project Structure

```
src/
 ├── dao
 ├── model
 ├── util
 └── view
```

## Configuration

Before running the project, update the database credentials in:

```
src/main/java/com/pharmacy/pharmacymanagementsystem/util/DBConnection.java
```

Replace:

```java
private static final String USER = "YOUR_MYSQL_USERNAME";
private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";
```

with your own MySQL username and password.

## How to Run

1. Clone or download the project.
2. Create the `pharmacy_db` database in MySQL.
3. Import the required tables.
4. Update the database credentials.
5. Open the project in NetBeans.
6. Build and Run.

## Author

Developed by 

**Palak Shekhawat**

**Java Intern**