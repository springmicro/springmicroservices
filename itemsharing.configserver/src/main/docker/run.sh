echo "*************************************************"
echo "Staring config server"
echo "*************************************************"
java -Djava.security.egd=file:/dev./urandom -jar /usr/local/configservice/@project.build.finalName@.jar