FROM eclipse-temurin:17
WORKDIR /app
COPY ./target/PropertyPortal-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "PropertyPortal-0.0.1-SNAPSHOT.jar"]