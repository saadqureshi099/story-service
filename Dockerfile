FROM openjdk:17
EXPOSE 8084
COPY target/story-service-docker.jar story-service-docker.jar

ENTRYPOINT ["java", "-jar","/story-service-docker.jar"]