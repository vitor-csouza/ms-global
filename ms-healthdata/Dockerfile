FROM openjdk:11
VOLUME /temp
EXPOSE 8080
ADD ./target/ms-healthdata-0.0.1-SNAPSHOT.jar ms-healthdata.jar
ENTRYPOINT ["java", "-jar", "/mshealthdata.jar"]