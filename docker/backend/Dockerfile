# Build stage
# Installs maven on the user's machine
FROM maven:3.8.7-openjdk-18 AS build
# Destination
WORKDIR /build
# Copies contents of pom.xml
COPY book-network-api/pom.xml .
# Downloads all dependencies even in an offline way
RUN mvn dependency:go-offline
# Copies the code's src folder to another folder named src
COPY book-network-api/src ./src
# Packages the application and skipping tests
RUN mvn clean package -DskipTests

# Runtime stage
FROM amazoncorretto:17
ARG PROFILE=dev
ARG APP_VERSION=1.0.0

WORKDIR /app
# Copies the jar file into the word directory
COPY --from=build /build/target/book-network-*.jar /app/

# App's port
EXPOSE 8088

# Enviornment variables configuration
ENV DB_URL=jdbc:postgresql://postgres-sql-bsn:5432/book_network
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} -Dspring.datasource.url=${DB_URL} book-network-${JAR_VERSION}.jar

