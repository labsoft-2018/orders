FROM java:8
MAINTAINER labsoft-2018

ADD target/orders-0.0.1-SNAPSHOT-standalone.jar /srv/orders.jar

EXPOSE 8854

CMD ["java", "-jar", "/srv/orders.jar"]
