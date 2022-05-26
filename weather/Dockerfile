#
#Build stage
#
FROM maven:3.8.4-jdk-11 AS build
COPY src /usr/weather/src
COPY pom.xml /usr/weather
RUN mvn -f /usr/weather/pom.xml clean package
#
#Packet stage
#
FROM openjdk:11
ENV PROFILE local
COPY --from=build /usr/weather/target/weather-0.0.1-SNAPSHOT.jar /usr/weather/weather.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/weather/weather.jar", "--spring.profiles.active=${PROFILE}"]