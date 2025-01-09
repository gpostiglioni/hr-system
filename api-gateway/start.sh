#!/bin/bash

port=$1

if [[ -z $port ]]; then
    port=8765
fi

mvn clean spring-boot:run -Dspring-boot.run.arguments="--server.port=$port"