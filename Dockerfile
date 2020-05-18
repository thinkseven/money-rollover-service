#
# Build stage
#
FROM maven:3.6.3-jdk-13 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml -Dmaven.test.skip=true clean package

#
# Package stage
#
FROM openjdk:13.0.2-jdk
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]