# spring-portfolio-manager
spring-portfolio-manager

Java (JDK 21) application for managing personal investments and assets.

It supports deposits, bonds, stocks, precious metals, cash, and fiat currencies (PLN, USD, EUR, CHF).
The application stores purchase details and maturity dates (when applicable) and calculates the total portfolio value.
Designed to be easily extendable with additional features such as exchange rates, profit/loss tracking, or persistence.

## Repository
```bash
git clone git@github.com:andprogrammer/spring-portfolio-manager.git
```

## Docker
```bash
docker build -t spring-portfolio-manager .
```

```bash
docker run -d -p 8080:8080 --name spring-portfolio-manager-container spring-portfolio-manager
```

http://localhost:8080/patients

```bash
docker stop spring-portfolio-manager-container
```

```bash
docker rm spring-portfolio-manager-container
```