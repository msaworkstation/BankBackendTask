# BankBackendTask

# For Api Documentation 
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config


## Current working APIs

### Get all users <br>
GET http://localhost:8080/users

### Get User Info <br>
GET http://localhost:8080/users/{UserName}

### Get Account by ID <br>
GET http://localhost:8080/accounts/1

### Get all account statements <br> 
POST http://localhost:8080/accounts/statements <br> 
`
{
    "id": 1
}
`
