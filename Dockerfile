FROM eclipse-temurin:21-jre
ADD target/user_repo.jar user_repo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user_repo.jar"]