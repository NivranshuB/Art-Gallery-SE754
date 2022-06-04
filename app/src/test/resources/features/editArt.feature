Feature: ManageExistingArt

  Background:
    Given Driver set up for edit art page

  Scenario: Edit title of art
    Given I am on an art-details page for "id"
    When I enter "New Title" as edit title field
    And I click on the submit edit button
    Then I should see successfully edit message