FROM maven:3.8.4-jdk-11-slim As equipementBuild
COPY src /home/equipementApp/src
COPY pom.xml /home/equipementApp
RUN mvn -f /home/equipementApp/pom.xml clean install

# Create Spring Boot image
FROM openjdk:11
COPY --from=equipementBuild /home/equipementApp/target/EquipmentService-0.0.1-SNAPSHOT.war equipment.war
ENTRYPOINT ["java", "-jar", "-Dserver.port=8002", "equipment.war"]
EXPOSE 8002
