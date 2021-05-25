FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springdocker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springdocker-0.0.1-SNAPSHOT.jar"]