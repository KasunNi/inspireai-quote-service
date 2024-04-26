# Use a base image with Java 11 (or your desired Java version)
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/inspireai-quoting-service-0.0.1-SNAPSHOT.jar .

# Expose the port that your application listens on (if applicable)
EXPOSE 8080

# Command to run the application when the container starts
CMD ["java", "-jar", "inspireai-quoting-service-0.0.1-SNAPSHOT.jar"]
