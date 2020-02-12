#!/usr/bin/env bash

#cd /tmp && tar jxf /tmp/phantomjs-2.1.1-linux-x86_64.tar.bz2 && cd /tmp/ml-web-pc/ && npm install && npm start && nginx
cd /tmp/ml-web-pc/ && npm run dev
/usr/sbin/nginx

