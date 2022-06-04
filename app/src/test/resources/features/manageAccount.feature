Feature: Manage Account
  This feature UI tests the manage account details page where a user can change their username, password, shipping
  details and their payment details.

  Background:
    Given Driver set up for manage account page
    And User is logged in

  Scenario: Navigation to manage-account page
    Given I start on the home page
    When I press the manage account button
    Then I should see the manage account page