FROM maven:3.8.4-jdk-11-slim As loginBuild
COPY src /home/loginApp/src
COPY pom.xml /home/loginApp
RUN mvn -f /home/loginApp/pom.xml clean install

# Create Spring Boot image
FROM openjdk:11
COPY --from=loginBuild /home/loginApp/target/gatewayrobospector-0.0.1-SNAPSHOT.jar login.jar
ENTRYPOINT ["java", "-jar", "-Dserver.port=8000", "login.jar"]
EXPOSE 8000
