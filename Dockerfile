#This is the base.
FROM java:8

#This is the port.
EXPOSE 8014:8014

#No idea
ADD /target/CheckAccountJar.jar CheckAccountJar.jar

#No idea
ENTRYPOINT ["java", "-jar", "CheckAccountJar.jar"]