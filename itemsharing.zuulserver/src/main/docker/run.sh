#!/bin/sh
echo "********************************************************"
echo "Starting zuul server "
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/zuulservice/@project.build.finalName@.jar

