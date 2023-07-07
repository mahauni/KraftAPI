FROM eclipse-temurin:17-jdk-alpine
COPY target/KraftAPI-1.0.jar /app/KraftAPI.jar
ENV url=jdbc:postgresql://postgres:5432/root
ENV passwd=password
ENV user=admin
WORKDIR /app
ENTRYPOINT ["java", "-jar", "KraftAPI.jar"]
EXPOSE 8080