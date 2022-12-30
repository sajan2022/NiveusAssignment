FROM openjdk:11
EXPOSE 8080
ADD target/docker-java-example.jar docker-java-example.jar
ENTRYPOINT [ "java","-jar","/docker-java-example.jar" ]