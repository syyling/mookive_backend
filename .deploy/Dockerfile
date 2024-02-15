FROM openjdk:17
ARG JAR_FILE=/build/libs/mookive_backend-0.0.1-SNAPSHOT.jar
COPY  ${JAR_FILE} mookive.jar
ENTRYPOINT ["java","-jar","/mookive.jar", "--spring.profiles.active=prod"]