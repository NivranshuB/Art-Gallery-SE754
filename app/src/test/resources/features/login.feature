Feature: Login
  This feature UI tests the login page and how users can test login into their account in the web application.

  Background:
    Given Driver set up for login page

  Scenario: Navigation to login page
    Given I am on the home page
    When I press the login button
    Then I should see the login page
