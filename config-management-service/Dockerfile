FROM openjdk:8
EXPOSE 8080
VOLUME /tmp
COPY target/*.jar config-management-service-0.1.jar
ENTRYPOINT ["java","-jar","/config-management-service-0.1.jar"]