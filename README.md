# Getting Started - BKN User

### Reference Documentation
For further reference, please consider the following sections:

* [Docker Container's Architecture Diagram](https://github.com/fernandooliveira19/bookings-architecture-diagram) 

### Dependencies

Dependencies used in this project


* Actuator
* Eureka Client
* Postgres

### Docker's commands

pull postgres image

* $ docker pull postgres:12-alpine

run database image

* $ docker run -p 5432:5432 --name bkn-user-pg12 --network bkn-net -e POSTGRES_PASSWORD=Famo2369 -e POSTGRES_DB=db_bkn_user postgres:12-alpine


create network

* $ docker network create bkn-net

clean and package

* $ .\mvnw clean package -DskipTests

build docker image

* $ docker build -t bkn-user:v1 .

run docker container

* $ docker run -P --network bkn-net -e SERVER_CLOUD_CONFIG_URI=${SERVER_CLOUD_CONFIG_URI} -e SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}  bkn-user:v1 
