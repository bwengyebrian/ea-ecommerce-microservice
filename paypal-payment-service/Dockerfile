FROM openjdk:8
EXPOSE 8080
VOLUME /tmp
COPY target/*.jar paypal-payment-service-0.1.jar
ENTRYPOINT ["java","-jar","/paypal-payment-service-0.1.jar"]