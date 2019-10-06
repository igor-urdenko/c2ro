FROM openjdk:8
ENV APP_DIR /app/graph-service
RUN mkdir -p $APP_DIR
WORKDIR $APP_DIR
COPY target/graph-svc-0.1.0-SNAPSHOT.jar $APP_DIR
EXPOSE 8080
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "graph-svc-0.1.0-SNAPSHOT.jar"]
