# Java ETL Pipeline (CSV → PostgreSQL)

This project demonstrates an end-to-end ETL (Extract, Transform, Load) pipeline built using Java and PostgreSQL.  
The pipeline reads data from a CSV file, cleans and validates the records, and loads only valid rows into a PostgreSQL database.

---

## 🚀 Features

- Extracts data from CSV file
- Cleans invalid records (missing name, missing marks, invalid marks)
- Loads valid data into PostgreSQL table
- Handles real-world issues:
  - Missing columns
  - Empty values
  - Duplicate primary keys
- Uses JDBC for database connectivity
- Version controlled using Git & GitHub

---

## 🛠 Tech Stack

- Java  
- PostgreSQL  
- JDBC  
- Git & GitHub  

---

## 📂 Project Structure

java-etl-pipeline/
│
├── StudentETL.java
├── students.csv.txt
├── .gitignore
└── README.md


---

## 📥 Input (CSV Sample)

id,name,marks
1,Ram,85
2,Krishn,90
3,Rahul,76
4,Ravi,93
5,Shyam,66
6,,88
7,Jenny,
8,Grace,54
9,,45
10,Rashmi,


---

## ✅ Data Cleaning Rules

A row is considered valid if:

- Name is not empty  
- Marks is not empty  
- Marks is between 0 and 100  

Invalid rows are skipped automatically.

---

## 🗄 Database Setup

```sql
CREATE DATABASE etl_project;

CREATE TABLE students_clean (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    marks INT
);


▶ How to Run
Place CSV file in project folder

Compile:

javac -cp ".;postgresql-42.7.9.jar" StudentETL.java
Run:

java -cp ".;postgresql-42.7.9.jar" StudentETL

📤 Output
Only valid records are inserted into PostgreSQL:

1 Ram 85
2 Krishn 90
3 Rahul 76
4 Ravi 93
5 Shyam 66
8 Grace 54


🎯 Learning Outcomes
Built real ETL pipeline using Java

Learned file handling and JDBC

Understood data validation and transformation

Practiced Git and GitHub workflow



👤 Author
Janaki Raman Gurivindala

