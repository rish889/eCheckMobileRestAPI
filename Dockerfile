FROM java:8

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR ./

# Prepare by downloading dependencies
ADD pom.xml ./pom.xml

# Adding source, compile and package into a fat jar
ADD src ./src

RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

RUN ["mvn", "package"]

EXPOSE 8080
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/eCheckMobileRestAPI-0.0.1-SNAPSHOT.jar"]