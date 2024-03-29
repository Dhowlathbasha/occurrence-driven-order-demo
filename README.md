# Occurrence Driven Order demo
## Event Stream
![event storm result](./doc-image/event_storming_result.jpg)
    
## Code Structure
#### Dependency Services
- Kafka: Event Store & Event Bus
#### Domain Aggregate
- Order
- Payment
- Shipment
#### Server Role
- Command-Side: 
  - handle command request 
  - write events to Kafka
- Query-Side: 
  - consume events from Kafka to build data view
  - return query request
- Event-Handler
  - consume events from Kafka to send command request to Command-side

## How to run application
### With local code
```shell
# should run build first
./gradlew build -x test

# run only dependency component (kafka, redis)  
docker compose -f Docker/kafka-docker-compose.yml -f Docker/redis-docker-compose.yml --env-file Docker/config/.env.docker -p occurrence-driven up

# run all command, query side, and dependencies 
docker compose -f Docker/observe-docker-compose.yaml -f Docker/boot-run-order-apps-docker-compose.yml -f Docker/boot-run-payment-apps-docker-compose.yml -f Docker/boot-run-shipment-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml -f Docker/redis-docker-compose.yml --env-file Docker/config/.env.docker -p occurrence-driven up

# run order command query and dependencies
docker compose -f Docker/observe-docker-compose.yaml -f Docker/boot-run-order-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml -f Docker/redis-docker-compose.yml --env-file Docker/config/.env.docker -p occurrence-driven up -d --scale prometheus=0

# run payment command query and dependencies
docker compose -f Docker/observe-docker-compose.yaml -f Docker/boot-run-payment-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml --env-file Docker/config/.env.docker -p occurrence-driven up -d --scale prometheus=0

# run shipment command query and dependencies
docker compose -f Docker/observe-docker-compose.yaml -f Docker/boot-run-shipment-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml --env-file Docker/config/.env.docker -p occurrence-driven up -d --scale prometheus=0

```

#### Run applications 
### With docker image on the Docker Hub 
```shell
# all service with all observability components and kafka
docker compose -f Docker/observe-docker-compose.yaml -f Docker/boot-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml -f Docker/redis-docker-compose.yml --env-file Docker/config/.env.docker --profile all -p occurrence-driven up
# all order service without observability
docker compose -f Docker/boot-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml -f Docker/redis-docker-compose.yml --env-file Docker/config/.env.docker --profile order -p occurrence-driven up
# only order-command-side
docker compose -f Docker/boot-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml -f Docker/redis-docker-compose.yml --env-file Docker/config/.env.docker --profile order -p occurrence-driven up --scale order-handler=0 --scale order-query=0
# only payment-command-side
docker compose -f Docker/boot-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml --env-file Docker/config/.env.docker --profile payment -p occurrence-driven up --scale payment-handler=0 --scale payment-query=0
# only shipment-command-side
docker compose -f Docker/boot-apps-docker-compose.yml -f Docker/kafka-docker-compose.yml --env-file Docker/config/.env.docker --profile shipment -p occurrence-driven up --scale shipment-handler=0 --scale shipment-query=0
``` 

- run by IDE 
  
  set the working directory as `{path-to-project-root}/occurrence-driven-order-demo`

## Run E2E test in local

### prerequisite
- install nektos/act (https://github.com/nektos/act)
- run docker deamon
### command
- for mac with M2 chip
```
act -j e2e-test --container-architecture linux/amd64
```
- for normal linux based kernel
```
act -j e2e-test
```

## Endpoint

| server           | swagger url                                  |
|------------------|----------------------------------------------|
| Order Command    | http://localhost:8081/swagger-ui/index.html  |
| Order Handler    | http://localhost:8082/swagger-ui/index.html  |
| Order Query      | http://localhost:8083/swagger-ui/index.html  |
| Payment Command  | http://localhost:9081/swagger-ui/index.html  |
| Payment Handler  | http://localhost:9082/swagger-ui/index.html  |
| Payment Query    | http://localhost:9083/swagger-ui/index.html  |
| Shipment Command | http://localhost:10081/swagger-ui/index.html |
| Shipment Handler | http://localhost:10082/swagger-ui/index.html |
| Shipment Query   | http://localhost:10083/swagger-ui/index.html |
| Grafana          | http://localhost:3200                        |
| Prometheus       | http://localhost:9090                        |