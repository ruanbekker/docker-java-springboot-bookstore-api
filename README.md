# docker-java-springboot-bookstore-api
Example: Java Spring Boot Bookstore API with Docker, MySQL and Liquibase

## Boot

```bash
docker compose up -d --build
```

## Database Migrations

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
curl -XPOST -H 'Content-Type: application/json' http://localhost:8080/api/books -d '{"title": "Example Book Title", "author": "Author Names"}'
```

Update a book:

```bash
curl -XPUT -H 'Content-Type: application/json' http://localhost:8080/api/books/6 -d '{"title": "foooooooomy Example Book"}'
```

View a single book:

```bash
curl http://localhost:8080/api/books/6
```

Delete a book:

```bash
curl -XDELETE http://localhost:8080/api/books/6
```
