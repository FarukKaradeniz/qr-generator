FROM openjdk:17-jdk-slim AS build
LABEL authors="faruk karadeniz"

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR qr-generator
COPY --from=build target/*.jar qr-generator.jar
ENTRYPOINT ["java", "-jar", "qr-generator.jar"]