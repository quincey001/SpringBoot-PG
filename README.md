# SpringBoot-PG
Java 17 
mysql-8.0.18
#### Dependencies:
```java
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-web'
compileOnly 'org.projectlombok:lombok:1.18.22'
annotationProcessor 'org.projectlombok:lombok:1.18.22'
runtimeOnly 'com.mysql:mysql-connector-j'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
implementation 'javax.validation:validation-api:2.0.1.Final'
implementation 'io.springfox:springfox-swagger2:2.9.2'
implementation 'io.springfox:springfox-swagger-ui:2.9.2'
testImplementation 'org.mockito:mockito-core:4.11.0'
 ```  
 
### Spring web: makes your project a web application, The spring-boot-starter-web dependency transitively pull 
in all dependencies related to web development. It uses Spring MVC, REST, and tomcat as a default embedded server.

### Spring data JPA: allows us to persist data in SQL databases using Spring Data and Hibernate, which is an implementation of the JPA.

### MySQL Driver: it is a dependency that connects the MySQL database to spring boot application.

OrderAPI is a RESTful api that used to create orders and update exist orders in MySQL database.

## (1)create an order
POST - http:localhost:8081/addOrder

Request body:
```java
{ 
    "items": [
        {  
            "name":"pear",
            "unitPrice": 3.0,
            "quantity":20
        } 
    ]
}
```


Response:
```java
{
    "id": 1,
    "totalAmount": 60.0,
    "items": [
        {
            "name": "pear",
            "unitPrice": 3.0,
            "quantity": 20
        }
    ]
}
```

## Update an order
PUT - http:localhost:8081/updateOrder/{id}

Request body:
```java
{
    "id": 1,
    "items": [
        {
            "name": "phone",
            "unitPrice": 239.0,
            "quantity": 1
        },
        {
            "name": "pen",
            "unitPrice": 9.0,
            "quantity": 1
        },
        {
            "name": "mac mini",
            "unitPrice": 2390.0,
            "quantity": 1
        }
    ]
}
```

Response:
```java 
{
    "id": 1,
    "totalAmount": 2638.0,
    "items": [
        {
            "name": "phone",
            "unitPrice": 239.0,
            "quantity": 1
        },
        {
            "name": "pen",
            "unitPrice": 9.0,
            "quantity": 1
        },
        {
            "name": "mac mini",
            "unitPrice": 2390.0,
            "quantity": 1
        }
    ]
}
```

