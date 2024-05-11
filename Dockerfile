FROM openjdk:17

WORKDIR /app

COPY target/soat3-ms-gateway-0.0.1-SNAPSHOT.jar /app/soat3-ms-gateway.jar

EXPOSE 9090

ENTRYPOINT [ "java", "-jar", "soat3-ms-gateway.jar" ]