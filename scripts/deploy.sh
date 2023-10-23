#!/usr/bin/env bash

echo 'Copy files...'

scp -i C:/Users/Paul/.ssh/id_rsa \
  target/QRService-0.0.1-SNAPSHOT.jar \
  paul@192.168.1.78:/home/paul/

echo 'Restart server...'

ssh -i C:/Users/Paul/.ssh/id_rsa paul@192.168.1.78 << EOT
pgrep java | xargs kill -9
nohup java -jar QRService-0.0.1-SNAPSHOT.jar > log.txt &

EOT

echo 'Bye'
