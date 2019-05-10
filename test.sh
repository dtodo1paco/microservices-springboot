#!/bin/bash

echo "Creating some Hospital Areas"
curl -sS -H "Content-Type: application/json" -X POST localhost:8082/hospitalArea/add -d '{"name":"Emergencies"}' 
curl -sS -H "Content-Type: application/json" -X POST localhost:8082/hospitalArea/add -d '{"name":"Oncology"}' 

echo "Creating some Patients"
curl -sS -H "Content-Type: application/json" -X POST localhost:8081/patients -d '{"givenName":"Max","familyName":"Colorado","birthDate":"1942-10-11", "hospitalAreaId":1}'
echo "Max Colorado in Hospital Area 1"
curl -sS -H "Content-Type: application/json" -X POST localhost:8081/patients -d '{"givenName":"Min","familyName":"Azulado","birthDate":"1981-12-11", "hospitalAreaId":2}'
echo "Min Azulado in Hospital Area 2"

echo "Getting patients for a specific Area"
curl -sS localhost:8082/hospitalArea/2/patients
curl -sS localhost:8082/hospitalArea/1/patients

echo "Done"
