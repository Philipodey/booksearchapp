FROM maven:3.8.7 as build
COPY bookSearchApp .
RUN mvn -B clean package -DskipTests
FROM openjdk:17-slim
COPY --from=build ./bookSearchApp/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["Java", "-jar", "app.jar"]



