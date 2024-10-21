FROM maven:3.9.9-sapmachine-23
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
CMD ["mvn","spring-boot:run","-Dspring-boot.run.arguments=--spring.config.location=classpath:/application-docker.properties"]