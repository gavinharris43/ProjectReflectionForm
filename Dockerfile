FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
COPY --from=maven-build /build/target/app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]

