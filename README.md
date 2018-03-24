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

Edge Server(Zuul): <http://localhost:8082/>

Endpoint to connect config-client via edge server:  <http://localhost:8082/api/restclient/client/>

Endpoint to connect Demo-Service via edge server:  <http://localhost:8082/api/restserver/service/>

Demo Service: <http://localhost:8081/>

Hystrix Dashboard: <http://localhost:9090/hystrix/>

Hystrix Stream: <http://localhost:8082/hystrix.stream/>

For client-side Load balancing we need to launch multiple instance of the Demo-Service on different ports(eg. 8081, 8085)

Auth Server: <http://localhost:9001>