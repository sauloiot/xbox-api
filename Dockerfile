FROM openjdk:17
VOLUME /tmp
EXPOSE 8888
ARG JAR_FILE=target/xbox-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} xbox-api.jar
ENTRYPOINT ["java","-Duser.timezone=America/Fortaleza","-jar","/xbox-api.jar"]

