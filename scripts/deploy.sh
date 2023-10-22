#!/usr/bin/env bash

echo 'Copy files...'

scp -i C:/Users/Paul/.ssh/id_rsa \
  out/artifacts/QRService_jar/QRService.jar \
  paul@192.168.1.78:/home/paul/

echo 'Restart server...'

ssh -i C:/Users/Paul/.ssh/id_rsa paul@192.168.1.78 << EOT
pgrep java | xargs kill -9
nohup java -jar QRService.jar > log.txt &

EOT

echo 'Bye'
