# -------- Build Stage --------
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy Gradle wrapper & config first (for caching)
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x gradlew

# Download dependencies (cached layer)
RUN ./gradlew build -x test --no-daemon || return 0

# Copy source code
COPY src src

# Build the application
RUN ./gradlew bootJar --no-daemon

# -------- Run Stage --------
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy built jar from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Render sets PORT automatically
ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]