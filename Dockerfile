FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]