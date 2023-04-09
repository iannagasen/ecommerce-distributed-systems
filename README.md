# ecommerce-distributed-systems

E-Commerce Distributed System

---

## **THE API GATEWAY**

### Configuration using Java and Properties

**`application.yml`**

```yaml
spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true

      routes:
        - id: test_route
          uri: http://httpbing.org:80/
          predicates:
            - Path=/get
          filters:
            - AddRequestHeader=MyHeader, MyUri
            - AddRequestHeader=MyParam, MyValue

        - id: product-service-route
          uri: lb://product-service
          predicates:
            - Path=/products
```

This is equivalent to a Java Configuration:

```java
@Bean
public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
  return builder.routes()
      .route(predicate -> predicate
        .path("/get")
        .filters(f -> f
          .addRequestHeader("MyHeader", "MyURI")
          .addRequestHeader("MyParam", "MyValue")
        )
        .uri("http://httpbin.org:80")
      )
      .route(predicate -> predicate
        .path("/products")
        .uri("lb://product-service")
      )
      .build();
}
```

The yml configuration is preferred because we dont need to recompile code when have changes

In the configuration. There are 2 routes:

1. test-route, which:
   - whenever you call `localhost:8675/get`
     - serverPort + path
   - it will be redirected to `http://httpbin.org:80/get`
     - uri + path
   - and has a filter to intercept request and add the 2 Http Headers:
     1. AddRequestHeader=MyHeader, MyUri
     2. AddRequestHeader=MyParam, MyValue
        <br>
        [Learn more GatwayFilters:](https://cloud.spring.io/spring-cloud-gateway/reference/html/#gatewayfilter-factories)

CODE:

```yaml
---
- id: test_route
  uri: http://httpbing.org:80/
  predicates:
    - Path=/get
  filters:
    - AddRequestHeader=MyHeader, MyUri
    - AddRequestHeader=MyParam, MyValue
```

2. product-service-route, which:
   - whenever `localhost:8675/products` is called
   - it will be redirected to `product-service/products`
   - now this instance of product-service is discovered by the **Service Discovery Server** aka our **Naming Server**
   - we have **`lb`** prefix to indicate that this is **LOAD BALANCED**
     - **Note that this is our API GATEWAY, one of the advantage of API Gateway is a Load Balancer**

Code:

```yaml
- id: product-service-route
  uri: lb://product-service
  predicates:
    - Path=/products
```
