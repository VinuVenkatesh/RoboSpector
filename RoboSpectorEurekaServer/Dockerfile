FROM maven:3.8.4-jdk-11-slim As eurekaServerBuild
COPY src /home/eurekaServerApp/src
COPY pom.xml /home/eurekaServerApp
RUN mvn -f /home/eurekaServerApp/pom.xml clean install

FROM openjdk:11
COPY --from=eurekaServerBuild /home/eurekaServerApp/target/RoboSpectorEurekaServer-0.0.1-SNAPSHOT.jar netflix-eureka-naming-server-1.0.jar
ENTRYPOINT ["java","-jar", "-Dserver.port=8005", "netflix-eureka-naming-server-1.0.jar"]
EXPOSE 8005