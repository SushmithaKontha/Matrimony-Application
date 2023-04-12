FROM java:17

EXPOSE 9090

ADD target/Matrimony-Application.war Matrimony-Application.war

ENTRYPOINT ["java","-war", "Matrimony-Application.war"]
