# Insurance Company
Spring Boot Application, in which the user can calculate the amount of a given insurance, and then purchase it and print the policy in PDF form. When new user registers an account, the application sends an e-mail verification link necessary to use its functionality.

## Tools and Technologies

* **Technology** : Java 11, Spring (Boot, MVC, Data JPA) , Lombok, JUnit 5, Mockito, Maven
* **Application Servicer** : Apache Tomcat Server
* **Database** : MySQL Database

## Getting Started

The source code can be checked out to your local and then build and run the application either from your IDE after importing to it as a maven project, or just from a command line. Follow these steps for the command-line option:

### Prerequisites

- [JDK 1.11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/installer/)

### Build & Run

1. Invoke `git clone https://github.com/Tomasz3976/insurance-company.git`
2. Invoke `cd insurance-company`
3. Create Database ```CREATE DATABASE insurancecompanydb;```
4. Create Database ```CREATE DATABASE insurancecompanytestdb;```
5. Set Username and Password in the ```main/resources/application.yml``` file
6. Set Username and Password in the ```test/resources/application.yml``` file
7. Invoke `mvn clean install`
8. Invoke `mvn spring-boot:run`
9. The server is running on **localhost:8080**

### Login

#### To login, enter the username and password for the account with selected role:
|   Role  	| Username 	| Password 	|
|:-------:	|:--------:	|:--------:	|
|   User  	|   user   	|   user   	|
| Manager 	|  manager 	|  manager 	|
|  Admin  	|   admin  	|   admin  	|

## Explore Rest APIs

To explore documentation, run the application and go to `http://localhost:8080/swagger-ui.html`
