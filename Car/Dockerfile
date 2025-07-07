# 1. Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# 2. Set the working directory inside the container
WORKDIR /app

# 3. Copy the JAR file into the container
COPY target/jc-0.0.1-SNAPSHOT.jar app.jar

# 4. Expose the port your app runs on (optional)
EXPOSE 8080

ENV PORT 8080

# 5. Set the command to run your JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
