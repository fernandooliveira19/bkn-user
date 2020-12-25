FROM openjdk:11
VOLUME /tmp
ADD ./target/bkn-user-0.0.1-SNAPSHOT.jar bkn-user.jar
ENTRYPOINT ["java","-jar","/bkn-user.jar"]