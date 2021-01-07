FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/BadManger-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#EXPOSE 8082
#EXPOSE 8761