#!/bin/bash

echo "============================================"
echo "Executando build das aplicações"
echo "============================================"
mvn -f api-gateway/pom.xml clean package
mvn -f eurekaserver/pom.xml clean package
mvn -f payroll-api/pom.xml clean package
mvn -f usuario/pom.xml clean package

echo "============================================"
echo "Executando build das imagens docker"
echo "============================================"
docker-compose build eureka-server api-gateway api-usuario payroll-api

echo "============================================"
echo "Subindo imagens para o registry"
echo "============================================"
docker-compose push eureka-server api-gateway api-usuario payroll-api
