FROM openjdk:latest
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} orderservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/orderservice.jar"]