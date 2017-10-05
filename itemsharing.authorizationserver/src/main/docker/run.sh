echo "*************************************************"
echo "Staring authorization server"
echo "*************************************************"
java -Djava.security.egd=file:/dev./urandom -jar /usr/local/authorizationservice/@project.build.finalName@.jar