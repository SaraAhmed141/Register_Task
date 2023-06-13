Project Name: Selenium Webdriver Automation with Java and Cucumber
This project is aimed at automating the registration process using Selenium WebDriver, Java, and Cucumber. 
The registration form enforces specific requirements such as capital letters for the first and last names, unique email addresses, and valid mobile numbers. 
Once the registration is completed successfully, the project verifies the appearance of a success message.

Prerequisites
Before running this project, ensure that you have the following prerequisites installed:
Java Development Kit (JDK)
Maven
Selenium WebDriver
Cucumber

Usage
To use the project, follow these steps:
1) Create your feature files in the src/test/resources/features directory. These files should contain the BDD scenarios describing the registration process.
2) Implement the step definitions for the scenarios in the src/test/java/stepdefinitions directory.
3) Run the automation tests using Cucumber
4) The tests will be executed based on the scenarios defined in the feature files. The automation process will open a browser, 
fill in the registration form with the specified inputs, and verify the success message.



