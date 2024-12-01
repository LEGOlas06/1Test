FROM ubuntu:24.04

RUN apt-get -y update &&  \
    apt-get -y install apache2 &&  \
    mkdir /var/run/apache2 -p && \
    apt-get -y clean

COPY ./target/aiit23k4b2-0.0.1-SNAPSHOT.jar /webserver.jar

EXPOSE 8081

CMD java -jar /webserver.jar

