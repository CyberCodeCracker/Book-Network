# Build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build

# Add pom.xml and resolve dependencies first
COPY pom.xml .
RUN mvn dependency:resolve

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM amazoncorretto:17
ARG PROFILE=dev
ARG APP_VERSION=1.0.0

WORKDIR /app
COPY --from=build /build/target/book-network-*.jar /app/

EXPOSE 8088

# Define build arguments
ARG EMAIL_HOST_NAME
ARG EMAIL_USERNAME
ARG EMAIL_PASSWORD
ARG DB_USERNAME
ARG DB_PASSWORD

ENV DB_URL=jdbc:postgresql://postgres:5432/book_network
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=admin
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}
ENV EMAIL_HOST_NAME=${EMAIL_HOST_NAME}
ENV EMAIL_USERNAME=${EMAIL_USERNAME}
ENV EMAIL_PASSWORD=${EMAIL_PASSWORD}

CMD java -jar \
  -Dspring.profiles.active=${ACTIVE_PROFILE} \
  -Dspring.datasource.url=${DB_URL} \
  -Dspring.datasource.username=${DB_USERNAME} \
  -Dspring.datasource.password=${DB_PASSWORD} \
  book-network-${JAR_VERSION}.jar