FROM java:17

EXPOSE 9090

ADD target/Matrimony-Application.jar Matrimony-Application.jar

ENTRYPOINT ["java","-jar", "Matrimony-Application.jar"]