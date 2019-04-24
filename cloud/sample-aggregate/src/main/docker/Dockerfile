FROM java:8
VOLUME /tmp
ADD sample-aggregate-1.0-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
RUN bash -c 'mkdir /log'
EXPOSE 9003
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom","-jar","/app.jar"]
