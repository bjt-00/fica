FROM openjdk:latest

ADD target/fantacy-info-center.jar fantacy-info-center.jar

ENTRYPOINT ["java","-jar","fantacy-info-center.jar"]

EXPOSE 8080