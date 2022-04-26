FROM openjdk:latest
ADD target/RestApiStudent.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]