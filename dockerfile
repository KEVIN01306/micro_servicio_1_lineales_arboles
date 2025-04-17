
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/micro_servicio_1_lineales_arboles-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]