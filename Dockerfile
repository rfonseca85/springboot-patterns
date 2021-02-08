FROM openjdk:8-alpine
EXPOSE 9090
ARG JAR_FILE=build/libs/springboot-patterns-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]