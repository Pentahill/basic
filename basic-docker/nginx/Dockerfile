FROM nginx

COPY web.nginx /etc/nginx/conf.d/web.conf
COPY start.sh /tmp/start.sh

RUN mkdir /tmp/nginx

ENTRYPOINT ["/tmp/start.sh"]

EXPOSE 8666