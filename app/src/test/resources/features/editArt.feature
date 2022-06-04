Feature: EditArt

  Background:
    Given Driver set up for edit art page

  Scenario: Edit title of art
    Given I am on an edit art details page for "1"
    When I enter "New" as edit title field
    And I click on the submit edit button
    Then I should see successfully edit message

   Scenario: Navigate to art-detail page
     Given I am on an edit art details page for "1"
     When I click go back to art detail page
     Then I should see the art detail page