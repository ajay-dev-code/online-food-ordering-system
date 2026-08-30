 🍔 Online Food Ordering System

A backend-focused food ordering application built using Java and Spring Boot that provides REST APIs for 
user authentication, restaurant management, food items, cart, orders, and payment handling.

 🚀 Features

* User registration and login
* JWT-based authentication
* Secure password storage using BCrypt
* Restaurant management
* Restaurant open/close status
* Food item/menu management
* Add food items to cart
* Cart quantity and price calculation
* Order creation and management
* Payment options such as Cash and UPI
* MySQL database integration
* RESTful APIs
* API testing using Postman
* Backend deployment on Railway

 🛠️ Technologies Used

 Backend

* Java
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* Maven

 Database

* MySQL

 API Testing

* Postman

 Version Control & Deployment

* Git
* GitHub
* Railway

 🏗️ Application Workflow

                    ┌──────────────────┐
                    │       User       │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │ Register / Login  │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │ JWT Authentication│
                    └────────┬─────────┘
                             │
                             ▼
                 ┌─────────────────────────┐
                 │      Restaurants        │
                 │  Open / Close / Rating  │
                 └────────────┬────────────┘
                              │
                              ▼
                    ┌──────────────────┐
                    │   Food / Menu    │
                    │  Select Items     │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │       Cart       │
                    │ Quantity & Price │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │      Order       │
                    │ Order & Quantity │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │     Payment      │
                    │    Cash / UPI    │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │  Order Completed  │
                    └──────────────────┘

 🔐 Authentication Flow


User
 │
 ▼
Register
 │
 ▼
Password encrypted using BCrypt
 │
 ▼
User stored in MySQL
 │
 ▼
Login
 │
 ▼
Credentials validated
 │
 ▼
JWT Token generated
 │
 ▼
Token sent to client
 │
 ▼
JWT included in API requests
 │
 ▼
Spring Security validates token
 │
 ▼
Authorized access to protected APIs

 🍽️ Restaurant & Food Workflow

Restaurant
    │
    ├── Name
    ├── Location
    ├── Rating
    └── Open / Close Status
          │
          ▼
       Food Menu
          │
          ├── Food Name
          ├── Price
          └── Availability
          │
          ▼
      Add to Cart

 🛒 Cart & Order Workflow

Select Food Item
       │
       ▼
   Add to Cart
       │
       ▼
Update Quantity
       │
       ▼
Calculate Total Price
       │
       ▼
   Place Order
       │
       ▼
Select Payment Method
       │
       ├── Cash
       └── UPI
       │
       ▼
 Order Created


 📡 API Modules

 Authentication

text
POST /auth/register
POST /auth/login


 Restaurant

text
Create Restaurant
Get Restaurants
Update Restaurant
Delete Restaurant


 Food Items

text
Create Food Item
Get Food Items
Update Food Item
Delete Food Item


 Cart

text
Add Item to Cart
View Cart
Update Quantity
Remove Item
Calculate Total

 Orders

text
Create Order
Get Orders
Update Order
Delete/Cancel Order


> Update the endpoint names above according to the actual mappings in your project.

 🗄️ Database

The application uses MySQL for persistent data storage.

Main data modules include:

* Users
* Restaurants
* Food Items
* Cart
* Orders
* Payments

The application uses Spring Data JPA/Hibernate for database interaction and entity relationships.

 🔒 Security

* JWT-based authentication
* BCrypt password hashing
* Spring Security
* Protected REST API endpoints
* Authentication and authorization
* User access control

 🧪 API Testing

APIs were tested using Postman.

Testing includes:

* User registration
* User login
* JWT authentication
* Restaurant APIs
* Food item APIs
* Cart operations
* Order operations
* Payment handling

 🌐 Deployment

The Spring Boot backend is deployed using Railway.

text
Client
  │
  │ HTTP Request
  ▼
Spring Boot REST API
  │
  ▼
Spring Security / JWT
  │
  ▼
Service Layer
  │
  ▼
Spring Data JPA
  │
  ▼
MySQL Database


 ▶️ How to Run Locally

 1. Clone the repository

bash
git clone YOUR_GITHUB_REPOSITORY_URL


 2. Open the project

Open the project in Eclipse or VS Code.

 3. Configure MySQL

Create a MySQL database and configure your database connection in:

text
application.properties


Add your database URL, username, and password.

4. Run the application

Run the main Spring Boot application.

The backend will start on:

text
http://localhost:8080


 5. Test the APIs

Open Postman and test the available REST API endpoints.

 📂 Project Structure


Online-Food-Ordering-System/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md


> Update the structure to match your actual project packages and folders.

 📌 Future Improvements

* Online payment gateway integration
* Order tracking
* Restaurant search and filtering
* Food search
* User profile management
* Email/SMS notifications
* Admin dashboard
* Order history


