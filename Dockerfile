# Pull base image.
FROM ubuntu:latest

RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install default-jre -y

ADD ./target/VIPER-0.0.1-SNAPSHOT.war VIPER-0.0.1-SNAPSHOT.war

EXPOSE 8080

CMD java -jar VIPER-0.0.1-SNAPSHOT.war