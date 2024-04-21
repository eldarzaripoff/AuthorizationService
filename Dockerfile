FROM openjdk:8-jdk-alpine

EXPOSE 8080

COPY target/AuthorizationService-1.0-SNAPSHOT.jar appByEldar.jar

CMD ["java", "-jar", "appByEldar.jar"]