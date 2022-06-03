Feature: Signup
  This feature UI tests the signup page where a user can fill in their basic details to create a new account.

  Background:
    Given Driver set up for signup page

  Scenario: Navigation to signup page
    Given I am currently on the home page
    When I press the signup button
    Then I should see the signup page