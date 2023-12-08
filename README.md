# docker-java-springboot-bookstore-api
Example: Java Spring Boot Bookstore API with Docker, MySQL and Liquibase

## Stack

- Java 15
- MySQL 5.7
- Liquibase (Database Migrations)
- Docker

## Getting Started

Start the database container:

```bash
docker compose up -d db
```

Run database migrations:

```bash
docker compose -f docker-compose-migrations.yaml run migrations
```

Build and start the application:

```bash
docker compose up -d --build
```

## Database Migrations (without docker compose)

This is when you want to run it natively / without docker compose.

To run migrations:

```bash
mvn liquibase:update
```

If a change was manually executed:

```bash
mvn liquibase:markNextChangeSetRan
```

## Requests

List all books:

```bash
curl http://localhost:8080/api/books
```

Create a book:

```bash
curl -XPOST -H 'Content-Type: application/json' http://localhost:8080/api/books -d '{"title": "Example Book Title", "author": "Author Name"}'
```

Update a book:

```bash
curl -XPUT -H 'Content-Type: application/json' http://localhost:8080/api/books/1 -d '{"title": "Another Title"}'
```

View a single book:

```bash
curl http://localhost:8080/api/books/1
```

Delete a book:

```bash
curl -XDELETE http://localhost:8080/api/books/1
```
