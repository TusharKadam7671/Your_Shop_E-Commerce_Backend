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
# Customer-Login Module

## POST ​/customer​/login logInCustomer
- Request URL - http://localhost:8888/customer/login
- Request body
```
{
  "email": "customer1@gmail.com",
  "mobileNo": "7219497671",
  "password": "password1111"
}
```
- Response body
```
CurrentCustomerSession(currentUserId=1, uuid=lSrBHY, localDateTime=2022-12-27T22:12:24.307200100)
```
---
## POST ​/customer​/logout logoutCustomer
- Request URL - http://localhost:8888/customer/logout?key=lSrBHY
- Response body 
```
logged out
```
---

# Admin module 

## POST /admin​/createadmin saveAdmin
- Request URL - http://localhost:8888/admin/createadmin
- Request body
```
{
  "adminId": 0,
  "adminPass": "admin1111"
}
```
- Response body
```
{
  "adminId": 3,
  "adminPass": "admin1111"
}
```
---

# Admin Login Module

### POST ​/admin​/login logInAdmin
- Request URL - http://localhost:8888/admin/login
- Request body
```
{
  "adminId": 3,
  "password": "admin1111"
}
```
- Response body
```
CurrentAdminSession(currentAdminId=3, uuid=Ed6BPm, localDateTime=2022-12-27T22:25:59.030726300)
```
---

## POST ​/admin​/logout logoutAdmin
- Request URL - http://localhost:8888/admin/logout?key=Ed6BPm
- Response body
```
Admin logged out
```
---