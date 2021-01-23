FROM alpine:latest
EXPOSE 8084
RUN apk --update --no-cache add ca-certificates openjdk11
RUN mkdir /app
ADD features*.jar /app/features.jar

ENTRYPOINT ["java", "-jar", "/app/features.jar"]