# syntax=docker/dockerfile:experimental

FROM  openjdk:8

# Refer to Maven build -> finalName
ARG JAR_FILE=target/userprofile-0.0.1.jar

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# cd /opt/app
WORKDIR /opt/app

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
