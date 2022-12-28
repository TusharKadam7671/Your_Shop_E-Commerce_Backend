# Your_Shop_E-Commerce_Backend

---
---
# Customer-Module

## POST ​/customer registerCustomer
- Request URL - http://localhost:8888/customer

```
{
  "address": {
    "addressId": 0,
    "buildingName": "Builiding1",
    "city": "Pune",
    "country": "India",
    "pincode": "415415",
    "state": "Maharashtra",
    "streetNo": "street1"
  },
  "customerId": 0,
  "email": "customer1@gmail.com",
  "firstName": "Customer1",
  "lastName": "Lastname1",
  "mobileNumber": "7219497671",
  "password": "password1111"
}
```
- Response Body
```
{
  "customerId": 2,
  "firstName": "Customer1",
  "lastName": "Lastname1",
  "mobileNumber": "7219497671",
  "address": {
    "addressId": 1,
    "streetNo": "street1",
    "buildingName": "Builiding1",
    "city": "Pune",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "415415"
  },
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
  "customerId": 2,
  "firstName": "Customer1",
  "lastName": "Lastname1",
  "mobileNumber": "7219497671",
  "address": {
    "addressId": 1,
    "streetNo": "street1",
    "buildingName": "Builiding1",
    "city": "Pune",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "415415"
  },
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
- Response Body
```
{
  "customerId": 2,
  "firstName": "NewCustomer1",
  "lastName": "Lastname1",
  "mobileNumber": "7219497671",
  "address": {
    "addressId": 1,
    "streetNo": "street1",
    "buildingName": "Builiding1",
    "city": "Pune",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "415415"
  },
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
---
## GET ​/getcustomer​/{customerId} getCustomerById
- Request URL - http://localhost:8888/getcustomer/2
- Response body
```
{
  "customerId": 2,
  "firstName": "NewCustomer1",
  "lastName": "Lastname1",
  "mobileNumber": "7219497671",
  "address": {
    "addressId": 1,
    "streetNo": "street1",
    "buildingName": "Builiding1",
    "city": "Pune",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "415415"
  },
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
---
## DELETE ​/customer​/{customerId} deleteCustomerByIdHandler
- Request URL - http://localhost:8888/customer/2
- Response body


```
{
  "customerId": 2,
  "firstName": "NewCustomer1",
  "lastName": "Lastname1",
  "mobileNumber": "7219497671",
  "address": {
    "addressId": 1,
    "streetNo": "street1",
    "buildingName": "Builiding1",
    "city": "Pune",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "415415"
  },
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

# Address module

### GET ​/address getAllAddressHandler
- Request URL - http://localhost:8888/address
- Response Body
```
[
  {
    "addressId": 6,
    "streetNo": "street4",
    "buildingName": "Building1",
    "city": "Mumbai",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "401401"
  }
]
```
---


### POST ​/address registerAddress
 - Request URL - http://localhost:8888/address?loginKey=vWFCRM
 - Request Body 
 ```
 {
  "addressId": 0,
  "buildingName": "Building1",
  "city": "Mumbai",
  "country": "India",
  "pincode": "401401",
  "state": "Maharashtra",
  "streetNo": "street4"
}
 ```
 - Response Body
 ```
 {
  "addressId": 7,
  "streetNo": "street4",
  "buildingName": "Building1",
  "city": "Mumbai",
  "state": "Maharashtra",
  "country": "India",
  "pincode": "401401"
}
 ```
 ---

### GET ​/getaddress​/{addressId} getAddressByIdHandler
- Request URL - http://localhost:8888/getaddress/6
- Response Body
```
{
  "addressId": 6,
  "streetNo": "street4",
  "buildingName": "Building1",
  "city": "Mumbai",
  "state": "Maharashtra",
  "country": "India",
  "pincode": "401401"
}
```
 ---
#### PUT ​/address updateAddressHandler
- Request URL - http://localhost:8888/address?loginkey=vWFCRM
- Request Body
```

{
    "addressId": 3,
    "streetNo": "street1",
    "buildingName": "NewBuiliding1",
    "city": "Pune",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "415416"
}
```
- Response Body
```
{
  "customerId": 4,
  "firstName": "Customer1",
  "lastName": "Lastname1",
  "mobileNumber": "7219497671",
  "address": {
    "addressId": 3,
    "streetNo": "street1",
    "buildingName": "NewBuiliding1",
    "city": "Pune",
    "state": "Maharashtra",
    "country": "India",
    "pincode": "415416"
  },
  "email": "customer1@gmail.com",
  "password": "password1111"
}
```
---

### DELETE ​/address​/{addressId} deleteAddressByIdHandler
- Request URL - http://localhost:8888/address/6
- Response Body
```
{
  "addressId": 6,
  "streetNo": "street4",
  "buildingName": "Building1",
  "city": "Mumbai",
  "state": "Maharashtra",
  "country": "India",
  "pincode": "401401"
}
```
---

