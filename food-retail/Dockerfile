FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY food-retail/ .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/food-retail-0.0.1-SNAPSHOT.jar"]