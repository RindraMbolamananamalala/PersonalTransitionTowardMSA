# Step 1 : Setting up Maven build environment
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2 : Setting up the runtime environment
# On utilise également le JRE 21 pour l'exécution
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]microcommercemicrocommercemicrocommerce