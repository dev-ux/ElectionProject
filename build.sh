#!/bin/bash

# Build backend
cd backend
./gradlew bootJar
cd ..

# Build frontend
cd frontend
npm install
ng build --prod
cd ..

# Build Docker images
docker-compose build
