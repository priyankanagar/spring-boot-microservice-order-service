# spring-boot-microservice-order-service
This is a simple spring boot application to demo REST API, Hibernate, JWT, Unit Testing

I have created a Spring Boot microservice which takes in a JSON request payload and creates an order. The application has the following features:

1. Creation of Spring Boot microservice and persist the data in 2 tables: Order and Order_Details
2. Persist the order in an RDBMS (i have used an in-memory H2 database to save some time as I developed it over the weekend)
3. Service layer is marked as @Transactional to make sure the order creation process respects ACID properties.
4. Spring Data JPA to use some out-of-the-box CRUD operations provided by Spring.
5. JWT is used to add security to the REST API.
6. Incoming request is validated using JSR Bean validation
7. Spring Boot 2.3.1 comes with an out-of-the-box support to dockerize the application
8. Unit Tests for Service and Controller layers


To run the application in local(without Docker), please make sure you have:

1. Maven 3.2+
2. Java 8, 9, 10 or 11

Steps:
1. Download the source code in your local
2. Unzip the code and open a terminal at the folder 
3. Run the command: mvn spring-boot:run 
4. Once the app is up, open a REST API client app like Postman and run the following commands:
    4.1. Call POST method on localhost:8080/authenticate with the following payload:
     {
      "username": "iamavaliduser",
      "password": "password"
    }
    Copy the token in the response. We will use it in the next step
    4.2. Call POST method on localhost:8080/authenticate with the following payload:
        Header: Key: Authorization Value Bearer <token from previous step>
        Sample Body: 
        {
          "orderAmount": "1000.00",
          "orderDetails": [
              {
                  "itemName": "Robot toy",
                  "itemAmount": "700"
              },
              {
                  "itemName": "Legos",
                  "itemAmount": "300"
              }
          ]
      }
     Note down the orderId in the response. We will use it in the next step
  4.3. Call POST method on localhost:8080/orders/{orderId from previous step} and Header: Key: Authorization Value Bearer <token from step i>. You should see the            order created in step ii.
