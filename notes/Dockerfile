#
#Build stage
#
FROM maven:3.8.4-jdk-11 AS build
COPY src /usr/notes/src
COPY pom.xml /usr/notes
RUN mvn -f /usr/notes/pom.xml clean package
#
#Packet stage
#
FROM openjdk:11
ENV PROFILE local
COPY --from=build /usr/notes/target/notes-0.0.1-SNAPSHOT.jar /usr/notes/notes.jar
#ADD target/notes-0.0.1-SNAPSHOT.jar /usr/notes/notes.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/notes/notes.jar", "--spring.profiles.active=${PROFILE}"]