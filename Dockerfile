# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Update the Maven wrapper properties file with the correct checksum
RUN sed -i 's/distributionSha256Sum=.*/distributionSha256Sum=<correct-checksum>/' .mvn/wrapper/maven-wrapper.properties

# Clean and package the application, skipping tests
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/test-deploy-0.0.1-SNAPSHOT.jar"]