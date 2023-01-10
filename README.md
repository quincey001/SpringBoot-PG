# SpringBoot-PG
OrderAPI is a RESTful api that used to create orders and update exist orders in MySQL database.

##(1)create an order
POST - http:localhost:8081/addOrder
Request body:
{ 
    "items": [
        {  
            "name":"pear",
            "unitPrice": 3.0,
            "quantity":20
        } 
    ]
}

Response:
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

##Update an order
PUT - http:localhost:8081/updateOrder/{id}
Request body:
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

Response:
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

