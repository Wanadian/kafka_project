FROM maven:3.8.4-openjdk-17 AS maven
WORKDIR application
COPY pom.xml .
COPY src ./src
ARG PORT
RUN mvn -DPORT=$PORT -DskipTests clean package
RUN mv /application/target/*.jar application.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/application/application.jar"]