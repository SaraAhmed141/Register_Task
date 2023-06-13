@Smoke
Feature: MyStepdefs| Register new user
  As an admin
  I want to add a new user
  So that they can use the system

  Scenario: Add a new user
    Given Open the website login page
    When Enter First Name which must start with capital letter
    And The first name is entered correctly
    And  Enter Last Name which must start with capital letter and can’t be equal First Name
    And The last name is entered correctly
    And I enter a unique email address
    And Enter a valid Mobile Number
    And  Select from dropdown list a course
    And Select from dropdown list a Batch
    And Select from Checkdown list
    And Click on Register button
    Then I should see "{string}" on the page
    Then I take a screenshot
