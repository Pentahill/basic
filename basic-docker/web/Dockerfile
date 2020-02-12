FROM openjdk:8

COPY ./mlp-1.0-SNAPSHOT.jar /tmp/mlp-1.0.jar
COPY start.sh /tmp/start.sh

RUN mkdir /tmp/web && touch /tmp/web/mlp_8666.log && touch /tmp/web/mlp_8667.log

ENTRYPOINT ["/tmp/start.sh"]

EXPOSE 8666
EXPOSE 8667

