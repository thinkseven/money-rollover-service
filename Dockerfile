FROM openjdk:13.0.2-jdk
ARG JAR_FILE=/target/money-rollover-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]