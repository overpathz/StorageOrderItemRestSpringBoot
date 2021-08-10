# Spring Boot REST application

Description:<br>
Application for manipulationg items and orders in the storage (database).<br><br>

Details:<br>
In the application we can create orders in storage.<br>
The order is valid for 10 minutes.<br>
Also, we can add items to storage, buy items (the number of items will be reduced in storage).<br><br>

[!] Not all tests are written because I had no experience before, but the test task made me understand and learn the basics in a few time. <br>

## Features
- ##### Logging system
- ##### Written Postman collection for testing RESTful web app (below)
- ##### DTO Pattern


## Technologies
- ##### Java 11
- ##### Spring Boot (Data JPA)
- ##### Lombok
- ##### Maven
- ##### Git
- ##### MySQL
- ##### JUnit


### Set Up
To run the project, you need to have installed Java at least 11 version and MySQL
There is application.properties file which contains different settings, you have to change these 3 lines to connect with your database
```
spring.datasource.url= ***
spring.datasource.username= ***
spring.datasource.password= ***
```

Main class - RestApplication, run this when you finish set up the project.

### Guide
API URL: localhost:yourport (port can be changed in application.properties file)
(I know there is a RESTful API standarts for URL, but i decided to make more user-friendly, just to demonstrate)
| Method   |     URL   |   Response    |
| ---      | ---       | ---
| GET      |     orders      |      receiving all orders        |
| POST     |     orders/create      |     creating order (fill method body)       |
| GET      |     items      |      receiving all items        |
| GET (with parameters)     |     items/buy      |      receiving items you have bought      |
| POST      |     items/add     |     creating new item (fill method body)        |

### Database

![image](https://i.ibb.co/R7Tbjg0/Screenshot-19.png)


### Written Postman collection
![image](https://i.ibb.co/Fq0tGsz/Screenshot-21.png)
