Feature: Login
  This feature UI tests the login page and how users can test login into their account in the web application.

  Background:
    Given Driver set up for login page

  Scenario: Navigation to login page
    Given I am on the home page
    When I press the login button
    Then I should see the login page

  Scenario Outline: Incorrect login
    Given I visit the login page
    When I enter <username> as user name field
    And I enter <password> as password field
    And I press the submit button
    Then I should see the incorrect credentials
    Examples:
      | username        | password        |
      | "WrongUsername" | "WrongPassword" |
      | "WrongUsername" | "password"      |
      | "user1"         | "WrongPassword" |