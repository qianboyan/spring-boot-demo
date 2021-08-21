FROM ha-service-base-image:1.0.0

WORKDIR /app

COPY ./target/demoService-0.0.1-SNAPSHOT.jar ./demoService-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/demoService-0.0.1-SNAPSHOT.jar"]
