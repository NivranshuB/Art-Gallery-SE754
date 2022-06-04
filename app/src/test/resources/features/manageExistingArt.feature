Feature: ManageExistingArt

  Background:
    Given Driver set up for remove art page

  Scenario: Remove existing artwork
    Given I am on the remove art page
    When I enter "1" as remove id field
    And I click on the Submit Id to Remove button
    Then I should art successfully remove message

  Scenario Outline: Remove invalid id
    Given I am on the remove art page
    When I enter <id> as remove id field
    And I click on the Submit Id to Remove button
    Then I should see remove art error
    Examples:
      | id    |
      | ""    |
      | "124" |