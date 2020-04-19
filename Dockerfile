FROM openjdk:13.0.2-jdk
ENTRYPOINT ["java","-jar","target/money-rollover-service-0.0.1-SNAPSHOT.jar"]