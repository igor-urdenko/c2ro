FROM openjdk:8
ENV APP_DIR /app/graph-service
ENV MONGO_SERVER mongo-db-server
ENV MONGO_PORT 11111
RUN mkdir -p $APP_DIR
WORKDIR $APP_DIR
COPY target/graph-svc-0.1.0-SNAPSHOT.jar $APP_DIR
EXPOSE 8080
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.data.mongodb.host=$MONGO_SERVER", "-Dspring.data.mongodb.port=$MONGO_PORT", "-jar", "graph-svc-0.1.0-SNAPSHOT.jar"]
