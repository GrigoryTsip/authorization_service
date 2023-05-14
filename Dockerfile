FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD build/libs/authorization_service-0.0.1-SNAPSHOT.jar authorization_service.jar
CMD ["java", "-jar", "authorization_service.jar"]
