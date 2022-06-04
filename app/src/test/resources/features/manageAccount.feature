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

  Scenario Outline: Change username unsuccessfully
    Given I am currently on the manage account page
    When I enter <username> in the new username field
    And I press the submit username button
    Then I should see the invalid username message

    Examples:
      | username |
      | ""       |
      | "user1"  |