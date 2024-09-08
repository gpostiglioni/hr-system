#!/bin/bash

port=$1

if [[ -z $port ]]; then
    port=8100
fi

mvn clean spring-boot:run -Dspring-boot.run.arguments="--server.port=$port" -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
