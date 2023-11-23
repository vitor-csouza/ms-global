FROM openjdk:11
VOLUME /temp
EXPOSE 8080
ADD ./target/ms-patients-0.0.1-SNAPSHOT.jar ms-patients.jar
ENTRYPOINT ["java", "-jar", "/mspatients.jar"]