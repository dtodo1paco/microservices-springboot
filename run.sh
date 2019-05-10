#!/bin/bash

echo "Starting hospital service..."
java -jar dist/target/microservices-1.0/hospital-service-1.0.jar &
echo "Starting patient service..."
java -jar dist/target/microservices-1.0/patient-service-1.0.jar &


echo "Done"
