# CoinLeaf – CRUD Cryptocurrency Tracker

## 1. Introduction
**CoinLeaf** is a web application that allows users to manage their cryptocurrency portfolios. Users can **create, read, update, and delete (CRUD)** cryptocurrency entries and fetch **live cryptocurrency prices** from the Coinbase API.  

The project emphasizes **modular design and scalability**, evolving from a console-based application to a fully functional web application with database persistence and live price updates.

---

## 2. Features
- **CRUD Operations:** Add, view, update, and delete cryptocurrencies in a portfolio.
- **Database Integration:** Persistent storage using MySQL with Spring Data JPA.
- **Live Price Fetching:** Real-time cryptocurrency prices via the Coinbase API.
- **RESTful API:** Fully functional API endpoints for portfolio management.
- **Web Interface:** Interactive front-end using Thymeleaf templates.
- **Extensible Design:** Modular structure for easy addition of new features.

---

## 3. Project Architecture

### Back-End
- **Java & Spring Boot:** Handles business logic and API endpoints.
- **Spring Data JPA:** Provides repository interfaces for database interaction.
- **CoinbaseService:** Fetches live cryptocurrency prices from the Coinbase API.

### Database
- **MySQL or PostgreSQL:** Stores portfolio data persistently.

### Front-End
- **Thymeleaf:** Server-side rendering of portfolio pages.
- **HTML/CSS & Bootstrap:** Responsive and styled user interface.

### Development Tools
- **Postman:** API testing.
- **Gradle or Maven:** Build automation and dependency management.

### Deployment
- Can be deployed on **Heroku** or **AWS**.

---

## 4. API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/api/cryptos` | Fetch all cryptocurrencies in the portfolio |
| `POST` | `/api/cryptos` | Add a new cryptocurrency to the portfolio |
| `GET`  | `/api/cryptos/{symbol}/price` | Fetch live price of a specific cryptocurrency |
| `DELETE` | `/api/cryptos/{id}` | Delete a cryptocurrency by its ID |

**Example POST Request Body:**
```json
{
  "symbol": "BTC",
  "quantity": 3.5,
  "initPrice": 27000.00,
  "curPrice": 27000.00
}
```
## 5. Project Architecture
crypto-tracker/
├── src/
│ └── main/
│ ├── java/
│ │ └── com/
│ │ └── sebacape/
│ │ └── coinleaf/
│ │ ├── controller/ # REST controllers
│ │ ├── model/ # Entity classes
│ │ ├── repository/ # JPA repositories
│ │ ├── service/ # Business logic & API services
│ │ ├── util/ # Utility classes
│ │ ├── exception/ # Custom exceptions
│ │ └── CoinLeafApplication.java
│ └── resources/
│ ├── static/ # CSS, JS, images
│ ├── templates/ # Thymeleaf templates
│ ├── application.properties
│ └── data.sql
├── build.gradle or pom.xml # Build configuration
├── README.md # Project documentation
└── logs/ # Application logs


This project is open-source under MIT License.
