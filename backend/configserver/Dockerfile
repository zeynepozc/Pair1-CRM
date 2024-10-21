FROM maven:3.9.9-sapmachine-23 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
FROM openjdk:23-jdk
COPY --from=build /app/target/configserver-0.0.1-SNAPSHOT.jar /app/configserver.jar
CMD ["java", "-jar", "/app/configserver.jar"]

