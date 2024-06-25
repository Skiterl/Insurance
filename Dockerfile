FROM gradle:8.8.0-jdk21-alpine as builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test
EXPOSE 8080
CMD ["java", "-jar", "./build/libs/insurance-0.0.1-SNAPSHOT.jar"]