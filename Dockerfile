FROM maven:3.6.3-openjdk-15 as builder
WORKDIR /app
COPY . /app
RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package
RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml -X test
RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml liquibase:update

FROM adoptopenjdk:15-jre-hotspot
ARG JAR_FILE=/app/target/*.jar
WORKDIR /app
COPY --from=builder $JAR_FILE /app/app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

