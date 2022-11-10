FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV HELLO_TARGET "http://localhost:8080/endpoint1"
ENV GOODBYE_TARGET "http://localhost:8080/endpoint2"
ENTRYPOINT java -jar /app.jar --helloTarget=${HELLO_TARGET} --goodbyeTarget=${GOODBYE_TARGET}