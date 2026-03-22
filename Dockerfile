# syntax=docker/dockerfile:1

ARG BUILD_BASE_IMAGE
ARG RUNTIME_BASE_IMAGE

FROM ${BUILD_BASE_IMAGE} AS build
WORKDIR /workspace
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q -DskipTests package

FROM ${RUNTIME_BASE_IMAGE}
WORKDIR /app
COPY --from=build /workspace/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
