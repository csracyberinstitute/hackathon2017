FROM java:8 

VOLUME /tmp

MAINTAINER Krishna Patury "krishna.patury@csra.com"

LABEL release-date="2017-04-17"

# Install maven
RUN apt-get update -y
RUN apt-get install -y maven


# Prepare by downloading dependencies
ADD pom.xml pom.xml

RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
ADD src src
RUN ["mvn", "verify"]
RUN ["mvn", "package"]


ADD target/air-manifest-micro-0.1.0.jar /app.jar
RUN sh -c 'touch /app.jar'


#Opens a port for linked containers
EXPOSE 8080

#The command that runs when the container starts
#CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "/app.jar"]
ENTRYPOINT [ "sh", "-c", "/usr/lib/jvm/java-8-openjdk-amd64/bin/java -jar /deployments/app.jar" ]
