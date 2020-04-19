FROM openjdk:13.0.2-jdk
COPY target/money-rollover-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]