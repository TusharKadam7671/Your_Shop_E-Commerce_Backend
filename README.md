# Your_Shop_E-Commerce_Backend

---
---
# Customer-Module

## POST ​/customer registerCustomer
- Request URL - http://localhost:8888/customer

```
{
  "customerId": 0,
  "email": "customer1@gmail.com",
  "firstName": "customer1",
  "lastName": "lastname1",
  "mobileNumber": "7219497671",
  "password": "password1111"
}
```
- Response Body
```
{
  "customerId": 1,
  "firstName": "customer1",
  "lastName": "lastname1",
  "mobileNumber": "7219497671",
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
---
## PUT ​/customer updateCustomerHandler
- Request URL - http://localhost:8888/customer

- Request Body
```
{
  "customerId": 1,
  "firstName": "newCustomer1",
  "lastName": "lastname1",
  "mobileNumber": "7219497671",
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
- Response Body
```
{
  "customerId": 1,
  "firstName": "newCustomer1",
  "lastName": "lastname1",
  "mobileNumber": "7219497671",
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
---
## GET ​/getcustomer​/{customerId} getCustomerById
- Request URL - http://localhost:8888/getcustomer/1
- Response body
```
{
  "customerId": 1,
  "firstName": "newCustomer1",
  "lastName": "lastname1",
  "mobileNumber": "7219497671",
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
---
## DELETE ​/customer​/{customerId} deleteCustomerByIdHandler
- Request URL - http://localhost:8888/customer/1
- Response body


```
{
  "customerId": 1,
  "firstName": "newCustomer1",
  "lastName": "lastname1",
  "mobileNumber": "7219497671",
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
---
