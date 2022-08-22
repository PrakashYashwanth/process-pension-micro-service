FROM openjdk:18-jdk-alpine
WORKDIR /
ADD target/process-pension-micro-service.jar process-pension-micro-service.jar
EXPOSE 8300
CMD java -jar process-pension-micro-service.jar

# FROM openjdk:18
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# EXPOSE 8300
# ENTRYPOINT ["java","-jar","app.jar"]