# HttpPayload API Testing Project

This project is designed to test various HTTP endpoints using Cucumber for behavior-driven development (BDD). The project is set up with Java, JUnit, and Cucumber.

## Project Structure
.
├── src
│ ├── main
│ │ └── java
│ │ └── http
│ │ └── CustomHttpClient.java
│ ├── test
│ │ ├── java
│ │ │ └── stepdefinitions
│ │ │ └── StepDefinitions.java
│ │ └── resources
│ │ └── features
│ │ └── users.feature
│ └── test
│ └── resources
│ └── payloads.properties
│ └── payloads
│ └── postUser.json
│ └── patchUser.json
│ └── putUser.json
├── README.md
└── pom.xml

## Prerequisites

- Java 17 (Amazon Corretto)
- Apache Maven
- IntelliJ IDEA (recommended for development)

## Setup Instructions

### Clone the Repository

git clone https://github.com/yourusername/HttpPayload.git

cd HttpPayload

"All the test cases have run properly."
Check the below Screenshot for this 

![image](https://github.com/Mannatabrol/httpclient/assets/119872048/dd32ee3c-3d4f-4ac7-b33f-532353612ffe)

You can also check the cucumber report which is as follows:- 
![image](https://github.com/Mannatabrol/httpclient/assets/119872048/74a0de3f-ddc0-442d-b98d-7e66cd6ea094)
