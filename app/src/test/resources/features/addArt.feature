Feature: AddArt

  Scenario: AddArtWithNoListing
    Given I am on the art page
    And I press the add art button
    When I enter "Title" as title field
    And I enter "Description" as description field
    And I enter "painting" as art type
    And I upload test image as image
    And I press the submit button
    Then I should see the new art displayed
