FROM amazoncorretto:17.0.7-alpine
COPY build/libs/server-0.0.1-SNAPSHOT.jar cicd.jar

ENV TZ Asia/Seoul
ARG PROFILES
ARG ENV

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "cicd.jar"]