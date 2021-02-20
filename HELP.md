# Getting Started

### Demo Documenation

This is a Spring boot project Please run DemoApplication.java to start the application. 
This project uses an H2 database that resides in memory to store any transactional data. 
When starting the application, there is a sql script that will insert test data into the offer table. 
The data structure has six columns:

ID, DESCRIPTION, CURRENCY, PRICE, EXPIRATION_DATE, CANCELED  

There is a test package that can run several tests, but the application must be running inorder to successfully 
execute the tests.

Below is a description of the remote services that can be called with the url and the body if applicable.

#####List offers
* Url: http://localhost:8080/ws/v1/offer/list
* Method: Get
* Response:
[
    {
        "id": 1,
        "description": "Wikipedia offer1",
        "currency": "£",
        "price": 0,
        "expirationDate": "2021-05-04T23:00:00.000+00:00",
        "canceled": false
    }
]

#####Add Offer
* http://localhost:8080/ws/v1/offer/add
* Method: Post
* Response:
{
  "description": "Offer2",
  "currency": "£",
  "price": 0,
  "expirationDate": "2021-01-04T23:00:00.000+00:00",
  "canceled": true
}

#####Add Offer
* http://localhost:8080/ws/v1/offer/update/1
* Method: PUT
* Response:
{
  "description": "Offer12",
  "currency": "£",
  "price": 0,
  "expirationDate": "2021-01-04T23:00:00.000+00:00",
  "canceled": false
}

#####Delete Offer
* http://localhost:8080/ws/v1/offer/delete/1
* Method: DELETE

#####Cancel Offer
* http://localhost:8080/ws/v1/offer/cancel/1
* Method: PUT


