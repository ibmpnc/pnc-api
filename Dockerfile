FROM openjdk:8
ADD target/pnc-api.jar pnc-api.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","pnc-api.jar"]