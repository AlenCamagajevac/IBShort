FROM openjdk:8-jdk-alpine


LABEL maintainer="alen.camagajevac@gmail.com"

EXPOSE 8080

ARG JAR_FILE=ibshort-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} ibshort.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ibshort.jar"]