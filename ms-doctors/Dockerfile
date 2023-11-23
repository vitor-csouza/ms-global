FROM openjdk:11
VOLUME /temp
EXPOSE 8080
ADD ./target/ms-doctors-0.0.1-SNAPSHOT.jar ms-doctors.jar
ENTRYPOINT ["java", "-jar", "/msdoctors.jar"]