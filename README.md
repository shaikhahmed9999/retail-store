**Problem Statement**

- On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you
get $ 45 as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

- Write a program in a Java – Spring boot with test cases such that given a bill, it finds
the net payable amount. Please note the stress is on object oriented approach and test
coverage. User interface is not required. What we care about:

**Required Activities**
- Object oriented programming approach, provide a high level UML class diagram of all the key classes in your solution. This can either be on paper
or using a CASE tool
- Unit tests to achieve good code coverage, good use of Mocking
- Code to be generic and simple
- Leverage today&#39;s best coding practices
- Clear README.md that explains how the code and the test can be run and how the coverage reports can be generated


**UML Class Diagram:**

![Alt Text](https://raw.githubusercontent.com/shaikhahmed9999/retail-store/main/ReportsAndUML/UML.png)
The UML class diagram for the key classes in the solution can be found in the uml directory.

**Sonar Report:**
![Alt Text](https://raw.githubusercontent.com/shaikhahmed9999/retail-store/main/ReportsAndUML/Reports.png);


**Structure Overview:**

- **Controller:** Contains the main logic for handling requests.
- **Service:** Contains business logic for applying discounts and calculating the net payable amount.
- **Model:** Contains the data models used by the application.
- **Repository:** Contains interfaces for accessing data.
- **Exception:** Contains custom exception classes.
- **Util:** Contains utility classes.

**Key Classes:**

- **UserController:** Handles incoming requests related to user data and bill processing.
- **UserService:** Provides methods for applying discounts and calculating the net payable amount.
- **User:** Represents user data including user type, tenure, and bill information.
- **Bill:** Represents bill information including total amount and list of items.
- **DiscountService:** Contains methods for applying various types of discounts.
- **DiscountStrategy:** Interface defining methods for applying discounts.
- **EmployeeDiscountStrategy, AffiliateDiscountStrategy, TenureDiscountStrategy, BillDiscountStrategy:** Implementations of DiscountStrategy interface for different types of discounts.

- **GroceryItem:** Represents grocery item information.



**Project Spec:**

**Project Information:**

- GroupId: com.store
- ArtifactId: retail
- Version: 3.2.4
- Name: retail
- Java Version: 17

**Dependencies:**

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Data REST HAL Explorer
- Mockito Core (for testing)
- H2 Database (runtime dependency)
- Lombok
- Spring Boot Starter Test (for testing)

**Build Plugins:**

- Spring Boot Maven Plugin
- Sonar Maven Plugin

**HalBrowser**
![Alt Text](https://raw.githubusercontent.com/shaikhahmed9999/retail-store/main/ReportsAndUML/HAL.png)
The UML class diagram for the key classes in the solution can be found in the uml directory.


**API Types**

- UserDetails
- Items
- Checkout

**User Details**

**Get**
```bash
GET /userDetails HTTP/1.1
Host: example.com
Content-Type: application/json

responce:
{
    "userName": "King",
    "userType": "AFFILIATE",
    "createdDate": "2024-04-02T09:02:10.465430232",
    "modifiedDate": 2024-04-02T09:02:10.465430232,
    "_links": {
        "self": {
            "href": "http://localhost:8080/userDetails/1"
        },
        "userDetail": {
            "href": "http://localhost:8080/userDetails/1"
        }
    }
}

```

**Post**
```bash
POST /userDetails HTTP/1.1
Host: example.com
Content-Type: application/json

{
    "userName":"Ahmed",
    "userType":"AFFILIATE"
}

```
**Put**
```bash
PUT /userDetails/{id} HTTP/1.1
Host: example.com
Content-Type: application/json

{
    "userName":"Ahmeds",
    "userType":"AFFILIATE"
}

```
**Delete**
```bash
DELETE /userDetails/{id} HTTP/1.1
Host: example.com
```

**Items**


**Get**
```Http
GET /items HTTP/1.1
Host: example.com
Content-Type: application/json

Response:
{
    "items": [
        {
            "id": 1,
            "name": "Milk",
            "price": 2.5,
            "_links": {
                "self": {
                    "href": "http://localhost:8080/items/1"
                },
                "item": {
                    "href": "http://localhost:8080/items/1"
                }
            }
        },
        {
            "id": 2,
            "name": "Bread",
            "price": 1.5,
            "_links": {
                "self": {
                    "href": "http://localhost:8080/items/2"
                },
                "item": {
                    "href": "http://localhost:8080/items/2"
                }
            }
        }
    ]
}
```

**Post**
```bash
POST /items HTTP/1.1
Host: example.com
Content-Type: application/json
{
    "itemName":"Ahmed",
    "description":"this is Ahmed",
    "price":100.0,
    "industry":"COSMETICS",
    "status":true
}
```
**Put**
```bash
PUT /items/{id} HTTP/1.1
Host: example.com
Content-Type: application/json
{
    "itemName":"Ahmed shaikh",
    "description":"this is Ahmed",
    "price":100.0,
    "industry":"COSMETICS",
    "status":true
}
```
**Delete**
```bash
DELETE /items/{id} HTTP/1.1
Host: example.com
```

**Checkout** 
**Get**
```bash
GET /checkout/bill HTTP/1.1
Host: example.com
Content-Type: application/json

Payload:
{
"userId" : 1,
"items": [    
{
    "itemId":3,
    "quantity":3
},
{
    "itemId":1,
    "quantity":1
}
]
}

responce
{
    "invoiceNo": 12,
    "customerName": "King",
    "totalDiscount": 35.0,
    "items": [
        {
            "itemName": "uuu",
            "quantity": 3,
            "price": 100.0
        }
    ],
    "totalAmount": 265.0,
    "dateAndTime": "2024-04-02T09:12:06.044074034"
}

```

**Service Setup**.

**PreSteps**

**Step 1:** 
- Add item in databases from endpoint.

```bash
POST /items HTTP/1.1
Host: example.com
Content-Type: application/json
{
    "itemName":"Ahmed",
    "description":"this is Ahmed",
    "price":100.0,
    "industry":"COSMETICS",
    "status":true
}
```
**Step 2:** 
- Add user in databases from endpoint;

```bash
POST /userDetails HTTP/1.1
Host: example.com
Content-Type: application/json

{
    "userName":"Ahmed",
    "userType":"AFFILIATE"
}
```
- Now all thing are setup or you can use data.sql file. 


**Get Invoice**
- Use checkout endpoint to get invoice.

**Request**
```bash
GET /checkout/bill HTTP/1.1
Host: example.com
Content-Type: application/json

Payload:
{
"userId" : 1,
"items": [    
{
    "itemId":1,
    "quantity":1
}
]
}
```
**responce**
```bash
{
    "invoiceNo": 12,
    "customerName": "King",
    "totalDiscount": 35.0,
    "items": [
        {
            "itemName": "Bread",
            "quantity": 3,
            "price": 100.0
        }
    ],
    "totalAmount": 265.0,
    "dateAndTime": "2024-04-02T09:12:06.044074034"
}
```


**Project Setup**

**Git Repository**

**Git Clone**

To clone this repository to your local machine, you can use the following command:

```bash
git clone https://github.com/shaikhahmed9999/retail-store.git
```

**JAR File Creation:**

**Build Your Project:**
- Use your build tool (e.g., Maven, Gradle) to build your project. If you're using Maven, you can use:

```bash
mvn clean package
```

**Locate Your JAR File:**

- After a successful build, your JAR file will typically be located in the **target** directory of your project.

**Run Your JAR File:**
- You can run your JAR file using the following command:

```bash
java -jar retail-0.0.1-SNAPSHOT.jar
```

**Docker** 

**Build Docker Image:**
- Build your Docker image using the Dockerfile:

```bash
docker build -t retail-0.0.1-SNAPSHOT .
```

**Run Docker Container:**
- Run your Docker container using the following command:

```bash
docker run -d -p 8080:8080 retail-0.0.1-SNAPSHOT
```

**Access Your Application:**
- Your application should now be accessible at http://localhost:8080 assuming your application runs on port 8080.
