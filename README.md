# ⚽ Footballers Spring App

A simple **Spring Boot REST API** for managing a database of football players (CRUD operations).
Built with **Java Spring Boot**, this project exposes REST endpoints to create, read, update, and delete footballer records.

---

## 🧠 Features

* 📌 RESTful endpoints for managing footballer data
* 🗂️ JSON-based API
* 🚀 Built with Spring Boot
* 🛠️ Clean architecture and layered design (Controller → Service → Repository)

---

## 📦 Technologies

| Layer      | Technology  |
| ---------- |-------------|
| Backend    | Java        |
| Framework  | Spring Boot |
| Build Tool | Gradle      |
| Database   | MongoDB     |
| IDE        | IntelliJ    |

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Samrat079/footballers_spring_app.git
cd footballers_spring_app
```

### 2. Build the Project

```bash
./gradlew build
```

### 3. Configure Database
Here is your updated section converted to **MongoDB with `application.yml`** format:

---

Update `application.yml` with your database settings:


```yaml
spring:
  mongodb:
    uri: mongodb://username:password@localhost:27017/footballer_db
```

---


> 📌 If using H2 (in-memory database), no changes are needed.

### 4. Run the Application

```bash
./gradlew bootRun
```

Or run the generated jar:

```bash
java -jar build/libs/footballers_spring_app.jar
```

By default, the app runs at:

```
http://localhost:8080
```

---

## 📍 API Endpoints

| Method | Endpoint            | Description        |
| ------ | ------------------- | ------------------ |
| GET    | `/footballers`      | Get all players    |
| GET    | `/footballers/{id}` | Get a player by ID |
| POST   | `/footballers`      | Add a new player   |
| PUT    | `/footballers/{id}` | Update a player    |
| DELETE | `/footballers/{id}` | Delete a player    |

> ⚠️ The actual endpoint paths may vary — adjust based on your controller mappings.

---

## 🧪 Example cURL Requests

### Get all players

```bash
curl -X GET http://localhost:8080/footballers
```

### Add a new player

```bash
curl -X POST http://localhost:8080/footballer \
 -H "Content-Type: application/json" \
 -d '{"name":"Lionel Messi","position":"Forward","team":"PSG"}'
```

---

## 🛠️ Project Structure

```
src/
└── main/
    ├── java/
    │   └── com.example.footballers/
    │       ├── controller/
    │       ├── service/
    │       ├── repository/
    │       └── model/
    └── resources/
        ├── application.properties
        └── data/
```

---

## 📌 How It Works

1. **Model** — Defines the footballer entity
2. **Repository** — Interface for DB operations
3. **Service** — Business logic layer
4. **Controller** — Exposes REST endpoints

---

## 🧩 Future Improvements

✔ Add **pagination & filtering**
✔ Add **Swagger/OpenAPI documentation**
✔ Integrate **Spring Security (JWT)**
✔ Add front-end UI 

---

## 🧑‍💻 Author

**Samrat079** — *Developer passionate about Java & backend development*
✨ Happy coding! 🙌

