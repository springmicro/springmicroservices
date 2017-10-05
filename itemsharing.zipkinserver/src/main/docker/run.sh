echo "*************************************************"
echo "Staring zipkin server"
echo "*************************************************"
java -Djava.security.egd=file:/dev./urandom -jar /usr/local/zipkinservice/@project.build.finalName@.jar