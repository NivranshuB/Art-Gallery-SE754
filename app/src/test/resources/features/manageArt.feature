Feature: ManageArt

  Scenario: Add art with no listing
    Given I am on the art page
    And I press the add art button
    When I enter "Title" as title field
    And I enter "Description" as description field
    And I select "painting" as art type
    And I enter "2x1m" as dimension field
    And I enter "artist" as artist name field
    And I upload test image as image
    And I press the submit button
    Then I should see the new art displayed
