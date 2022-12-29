# Your_Shop_E-Commerce_Backend

---
---
# Customer-Module

## POST ​/customer registerCustomer
- **Request URL** - http://localhost:8888/customer
- **Request Body**
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
- **Response Body**
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
- **Request URL** - http://localhost:8888/customer

- **Request Body**
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
- **Response Body**
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
- **Request URL** - http://localhost:8888/getcustomer/2
- **Response body**
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
- **Request URL** - http://localhost:8888/customer/2
- **Response body**


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
- **Request URL** - http://localhost:8888/customer/login
- **Request Body**
```
{
  "email": "customer1@gmail.com",
  "mobileNo": "7219497671",
  "password": "password1111"
}
```
- **Response Body**
```
CurrentCustomerSession(currentUserId=1, uuid=lSrBHY, localDateTime=2022-12-27T22:12:24.307200100)
```
---
## POST ​/customer​/logout logoutCustomer
- **Request URL** - http://localhost:8888/customer/logout?key=lSrBHY
- **Response Body**
```
logged out
```
---

# Admin module 

## POST /admin​/createadmin saveAdmin
- **Request URL** - http://localhost:8888/admin/createadmin
- **Request Body**
```
{
  "adminId": 0,
  "adminPass": "admin1111"
}
```
- **Response Body**
```
{
  "adminId": 3,
  "adminPass": "admin1111"
}
```
---

# Admin Login Module

## POST ​/admin​/login logInAdmin
- **Request URL** - http://localhost:8888/admin/login
- **Request Body**
```
{
  "adminId": 3,
  "password": "admin1111"
}
```
- **Response Body**
```
CurrentAdminSession(currentAdminId=3, uuid=Ed6BPm, localDateTime=2022-12-27T22:25:59.030726300)
```
---

## POST ​/admin​/logout logoutAdmin
- **Request URL** - http://localhost:8888/admin/logout?key=Ed6BPm
- **Response Body**
```
Admin logged out
```
---

# Address module

## GET ​/address getAllAddressHandler
- **Request URL** - http://localhost:8888/address
- **Response Body**
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


## POST ​/address registerAddress
 - **Request URL** - http://localhost:8888/address?loginKey=vWFCRM
 - **Request Body**
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
 - **Response Body**
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

## GET ​/getaddress​/{addressId} getAddressByIdHandler
- **Request URL** - http://localhost:8888/getaddress/6
- **Response Body**
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
## PUT ​/address updateAddressHandler
- **Request URL** - http://localhost:8888/address?loginkey=vWFCRM
- **Request Body**
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
- **Response Body**
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

## DELETE ​/address​/{addressId} deleteAddressByIdHandler
- **Request URL** - http://localhost:8888/address/6
- **Response Body**
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

# Product Module

## POST ​/product​/addproduct addProduct
- **Request URL** - http://localhost:8888/product/addproduct
- **Request Body**
```
{
  "category": {
    "catId": 1,
    "categoryName": "Electronics"
  },
  "color": "red",
  "dimension": "80 x 170 mm",
  "manufacturer": "motorola",
  "price": 12000,
  "productId": 1,
  "productName": "moto e4 plus",
  "quantity": 45,
  "specification": "Not available"
}

```
- **Response Body**
```
{
  "productId": 8,
  "productName": "moto e4 plus",
  "price": 12000,
  "color": "red",
  "dimension": "80 x 170 mm",
  "specification": "Not available",
  "manufacturer": "motorola",
  "quantity": 45,
  "category": {
    "catId": 1,
    "categoryName": "Electronics"
  }
}
```
---

## DELETE ​/product​/deleteproduct​/{productId} removeProduct
- **Request URL** - http://localhost:8888/product/deleteproduct/8
- **Response Body**
```
{
  "productId": 8,
  "productName": "moto e4 plus",
  "price": 12000,
  "color": "red",
  "dimension": "80 x 170 mm",
  "specification": "Not available",
  "manufacturer": "motorola",
  "quantity": 45,
  "category": {
    "catId": 1,
    "categoryName": "Electronics"
  }
}
```
---

## PUT ​/product​/product updateProductHandler
- **Request URL** - http://localhost:8888/product/product
- **Request Body**
```
{
  "productId": 9,
  "productName": "NEW moto e4 plus",
  "price": 18000,
  "color": "red",
  "dimension": "80 x 170 mm",
  "specification": "5G",
  "manufacturer": "motorola",
  "quantity": 44,
  "category": {
    "catId": 1,
    "categoryName": "Electronics"
  }
}
```
- **Response Body**
```
{
  "productId": 9,
  "productName": "NEW moto e4 plus",
  "price": 18000,
  "color": "red",
  "dimension": "80 x 170 mm",
  "specification": "5G",
  "manufacturer": "motorola",
  "quantity": 44,
  "category": {
    "catId": 1,
    "categoryName": "Electronics"
  }
}
```
---

## GET ​/product​/viewallproduct getAllProduct
- **Request URL** - http://localhost:8888/product/viewallproduct
- **Response Body**
```
[
  {
    "productId": 9,
    "productName": "NEW moto e4 plus",
    "price": 18000,
    "color": "red",
    "dimension": "80 x 170 mm",
    "specification": "5G",
    "manufacturer": "motorola",
    "quantity": 44,
    "category": {
      "catId": 1,
      "categoryName": "Electronics"
    }
  },
  {
    "productId": 10,
    "productName": "moto e4 plus",
    "price": 12000,
    "color": "red",
    "dimension": "80 x 170 mm",
    "specification": "Not available",
    "manufacturer": "motorola",
    "quantity": 45,
    "category": {
      "catId": 1,
      "categoryName": "Electronics"
    }
  }
]
```
---

## GET ​/product​/viewproductbyid​/{productId} viewProduct
- **Request URL** - http://localhost:8888/product/viewproductbyid/9
- **Response Body**
```
{
  "productId": 9,
  "productName": "NEW moto e4 plus",
  "price": 18000,
  "color": "red",
  "dimension": "80 x 170 mm",
  "specification": "5G",
  "manufacturer": "motorola",
  "quantity": 44,
  "category": {
    "catId": 1,
    "categoryName": "Electronics"
  }
}
```
---