# Managed DB with Spring Boot 🚗

A Spring Boot project demonstrating **CRUD operations** with a managed PostgreSQL database using **Supabase**. This project showcases integrating a cloud-managed database into a Java backend application.

---

## Table of Contents

* [Project Overview](#project-overview)
* [Technologies](#technologies)
* [Features](#features)
* [Setup & Installation](#setup--installation)
* [API Endpoints](#api-endpoints)
* [Supabase Table Showcase](#supabase-table-showcase)
* [Testing](#testing)
* [License](#license)

---

## Project Overview

This project demonstrates:

* Connecting a Spring Boot application to a **managed cloud database** (Supabase).
* Performing **CRUD operations** (Create, Read, Update, Delete) on a `Car` entity.
* Exposing **RESTful APIs** for backend operations.
* Using **Spring Data JPA** for database management.

This is a practical example of working with **real-world managed databases** for backend applications.

---

## Technologies

* Java 23
* Spring Boot 3
* Spring Data JPA
* Lombok
* Maven
* Supabase (Managed PostgreSQL)

---

## Features

* Add new cars to the database.
* Retrieve cars by **ID** or **model**.
* Update existing car details.
* Delete cars from the database.
* Integrates with a **managed cloud database** for production-level experience.

---

## Setup & Installation

1. **Clone the repository**:

```bash
git clone https://github.com/yourusername/managed-db-springboot.git
cd managed-db-springboot
```

2. **Configure database connection** in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://YOUR_SUPABASE_DB_URL:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the application**:

```bash
mvn spring-boot:run
```

---

## API Endpoints

| Method | Endpoint                    | Description        |
| ------ | --------------------------- | ------------------ |
| POST   | `/api/v1/car/save`          | Add a new car      |
| GET    | `/api/v1/car/id/{id}`       | Get car by ID      |
| GET    | `/api/v1/car/model/{model}` | Get car by model   |
| PUT    | `/api/v1/car/update/{id}`   | Update car details |
| DELETE | `/api/v1/car/{id}`          | Delete car by ID   |

---

## Supabase Table Showcase

Below is the screenshot of the `Car` table in Supabase after inserting data via the application:

![Supabase Table Screenshot](https://github.com/user-attachments/assets/97ac23da-c23b-4977-88c2-296d488acaa1)


---

## Testing

Use **Postman** or **cURL** to test the APIs. Example to create a car:

```json
POST /api/v1/car/save
{
  "model": "BMW M5",
  "engine": "V8"
}
```

---

## License

MIT License © 2025
