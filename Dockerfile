# take source code and package as jar
FROM maven:3.6.3-openjdk-8 as builder
COPY src/ src/
COPY pom.xml pom.xml
RUN mvn package -Dmaven.test.skip

#run jar
FROM openjdk:latest as runner
COPY --from=builder target/devops-demo.jar devops-demo.jar
ENTRYPOINT [ "java", "-jar", "/devops-demo.jar" ]