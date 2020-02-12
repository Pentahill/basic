#!/usr/bin/env bash

nohup java -jar /tmp/mlp-1.0.jar --server.port=8666 > /tmp/web/mlp_8666.log 2>&1 &
nohup java -jar /tmp/mlp-1.0.jar --server.port=8667 > /tmp/web/mlp_8667.log 2>&1 &

/usr/bin/env bash
