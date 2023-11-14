FROM openjdk:17
EXPOSE 9912
ADD target/emp-service.jar emp-service.jar
ENTRYPOINT [ "java","-jar", "/emp-service.jar"]