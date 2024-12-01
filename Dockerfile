FROM ubuntu:24.04

RUN apt-get -y update && \
    apt-get -y install apache2 openjdk-17-jdk && \
    mkdir -p /var/run/apache2 && \
    apt-get -y clean

COPY ./target/aiit23k4b2-0.0.1-SNAPSHOT.jar /webserver.jar

ENV APACHE_RUN_USER=www-data \
    APACHE_RUN_GROUP=www-data \
    APACHE_LOG_DIR=/var/log/apache2 \
    APACHE_SERVER_NAME=localhost \
    APACHE_RUN_DIR=/var/run/apache2

EXPOSE 8081

CMD ["java", "-jar", "/webserver.jar"]