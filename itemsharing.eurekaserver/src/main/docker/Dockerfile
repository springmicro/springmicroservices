FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/eurekaservice
ADD @project.build.finalName@.jar /usr/local/eurekaservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh