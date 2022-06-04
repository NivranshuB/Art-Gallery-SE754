Feature: ManageExistingArt

  Background:
    Given Driver set up for remove art page

  Scenario: Remove existing artwork
    Given I am on the remove art page
    When I enter "1" as remove id field
    Then I should art successfully remove message