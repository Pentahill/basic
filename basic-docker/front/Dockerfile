FROM node

ENV PHANTOMJS_HOME=/tmp/phantomjs-2.1.1-linux-x86_64
ENV PATH=$PHANTOMJS_HOME/bin:$PATH

#COPY ml-web-pc /tmp/ml-web-pc
COPY phantomjs-2.1.1-linux-x86_64.tar.bz2 /tmp/phantomjs-2.1.1-linux-x86_64.tar.bz2
COPY start.sh /tmp/start.sh

RUN apt-get update && apt-get install -y nginx
COPY front.nginx /etc/nginx/conf.d/front.conf

RUN cd /tmp && tar jxf /tmp/phantomjs-2.1.1-linux-x86_64.tar.bz2 && cd /tmp/ml-web-pc/ && npm install

ENTRYPOINT ["/tmp/start.sh"]

EXPOSE 3000
EXPOSE 3001

