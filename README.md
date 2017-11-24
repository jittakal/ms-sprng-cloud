# Micro-services - Spring Cloud

Micro-services using spring cloud

## Spring Cloud Eureka Service Discovery

``` cmd
> service-discovery-euraka$ ./mvnw spring-boot:run
```

Euraka Server: <http://localhost:8761>

## Spring Cloud Configuration Server

``` cmd
> config-server$ ./mvnw spring-boot:run
```

Configuration Server: <http://localhost:8888/config-client/dev>

## Spring Cloud Configuration Client

``` cmd
> config-client$ ./mvnw spring-boot:run
```

Configuration Client: <http://localhost:9090/>
