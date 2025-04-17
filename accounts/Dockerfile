#Start with a base image containing java runtime
FROM openjdk:21-jdk

LABEL "org.opencontainers.image.authors"="eazybytes.com"

#Add the application jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Run this command to execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]