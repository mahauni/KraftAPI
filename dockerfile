FROM eclipse-temurin:17-jdk-alpine
# add bash for debug and dev processes
# comment out later
RUN apk add bash
COPY target/KraftAPI-0.0.1-SNAPSHOT.jar /app/KraftAPI.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "KraftAPI.jar"]
EXPOSE 8080