FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./backend/build/libs/voting-app.jar .

EXPOSE 8080

CMD ["java", "-jar", "voting-app.jar"]
