FROM java:8
COPY target/devops-demo.jar devops-demo.jar
ENTRYPOINT [ "java", "-jar", "/devops-demo.jar" ]