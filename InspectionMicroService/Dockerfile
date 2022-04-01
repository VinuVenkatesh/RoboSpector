FROM maven:3.8.4-jdk-11-slim As inspectionBuild
COPY src /home/inspectionApp/src
COPY pom.xml /home/inspectionApp
RUN mvn -f /home/inspectionApp/pom.xml clean install

# Create Spring Boot image
FROM openjdk:11
COPY --from=inspectionBuild /home/inspectionApp/target/InspectionMicroService-0.0.1-SNAPSHOT.jar inspection.jar
ENTRYPOINT ["java", "-jar", "-Dserver.port=8004", "inspection.jar"]
EXPOSE 8004
