FROM openjdk:13.0.2-jdk
ARG JAR_FILE=target/money-rollover-service*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]