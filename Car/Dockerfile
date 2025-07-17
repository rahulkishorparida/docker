FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/jc-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

# 4. Expose the port your app runs on (optional)
#EXPOSE 8080
#ENV PORT 8080