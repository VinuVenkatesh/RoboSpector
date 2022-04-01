FROM maven:3.8.4-jdk-11-slim As loginBuild
COPY src /home/inspectionResultApp/src
COPY pom.xml /home/inspectionResultApp
RUN mvn -f /home/inspectionResultApp/pom.xml clean install

# Create Spring Boot image
FROM openjdk:11
COPY --from=loginBuild /home/inspectionResultApp/target/InspectionResultMicroService-0.0.1-SNAPSHOT.jar inspectionResult.jar
ENTRYPOINT ["java", "-jar", "-Dserver.port=8003", "inspectionResult.jar"]
EXPOSE 8003
