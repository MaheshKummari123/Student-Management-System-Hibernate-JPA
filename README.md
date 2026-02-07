# 🎓 Student Management System – Hibernate (JPA) & PostgreSQL

A console-based **Student Management System** built using **Hibernate with JPA (EntityManager)** and **PostgreSQL**.  
This project performs full **CRUD operations** along with **advanced search functionality** using **JPQL**, implemented using **pure JPA (RESOURCE_LOCAL)** without Spring or Spring Boot.

---

## 🚀 Project Overview

This application allows users to manage student records efficiently through a menu-driven console interface.  
It follows the **DAO design pattern** and demonstrates how Hibernate manages entity lifecycle, persistence context, and transactions internally.

---

## 🎯 Objectives

- Understand Hibernate internals without Spring abstraction  
- Learn EntityManager & EntityTransaction usage  
- Implement JPQL queries for dynamic data retrieval  
- Practice DAO pattern with clean architecture  

---

## ✨ Features

- ➕ Add new student  
- 📄 View students with filters:
  - Fetch by ID
  - Fetch by Name
  - Fetch by Email
  - Fetch by Course
  - Fetch all records
- ✏️ Update student details:
  - Name
  - Email
  - Course
  - All fields
- ❌ Delete student by ID  
- 🔍 JPQL-based search operations  
- 🔄 Transaction handling using EntityTransaction  

---

## 🛠 Tech Stack

- Java SE 8  
- Hibernate 5.6 (JPA)  
- PostgreSQL  
- Maven  
- JPQL  
- Console-based UI  

---

## 📂 Project Structure
src/main/java
└── hibernatestudentmanagement
├── main
│ └── App.java
├── dao
│ └── StudentDAO.java
├── entity
│ └── Student.java
└── util
└── EMFObject.java

src/main/resources
└── META-INF
└── persistence.xml


---

## 🔁 Application Flow

User Input
↓
App.java (Main Menu)
↓
StudentDAO (DAO Layer)
↓
EntityManager
↓
PostgreSQL Database

---

## 🔄 Hibernate Workflow

1. EntityManagerFactory is created using `persistence.xml`
2. EntityManager manages the persistence context
3. EntityTransaction handles commit & rollback
4. JPQL is used for SELECT operations
5. Hibernate synchronizes entity state with database

---

## 🔍 JPQL Queries Used

sql
SELECT s FROM Student s
SELECT s FROM Student s WHERE s.id = :i
SELECT s FROM Student s WHERE s.name = :n
SELECT s FROM Student s WHERE s.email = :e
SELECT s FROM Student s WHERE s.course = :c


▶️ How to Run

1. Clone the repository

2. Create a PostgreSQL database named school

3. Update DB credentials in persistence.xml

4. Run App.java

5. Use console menu to perform CRUD & search operations


🧠 Learning Outcomes

- Deep understanding of Hibernate Entity Lifecycle

- Hands-on experience with EntityManager & transactions

- Writing efficient JPQL queries

- DAO design pattern implementation

- PostgreSQL integration using Hibernate

- Building applications using pure JPA

🔮 Future Enhancements

-> Convert to Spring Boot

-> Add REST APIs

-> Add Web UI (JSP / React)

-> Pagination & sorting

-> Exception handling & logging



👨‍💻 Author

Kummari Mahesh
Java & Backend Developer
Hibernate | JPA | PostgreSQL | Spring Boot (Learning)
