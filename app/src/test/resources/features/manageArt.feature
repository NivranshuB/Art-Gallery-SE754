Feature: ManageArt

  Scenario: Add art with no listing
    Given I am on the add art page
    When I enter "Title" as title field
    And I enter "Description" as description field
    And I select "1" as art type
    And I enter "2x1m" as dimension field
    And I enter "artist" as artist name field
    And I enter "testImage.png" as image field
    And I press the submit button
    Then I should see the new art displayed

  Scenario: Add art with buy-now
    Given I am on the add art page
    When I enter "Title" as title field
    And I enter "Description" as description field
    And I select "1" as art type
    And I enter "2x1m" as dimension field
    And I enter "artist" as artist name field
    And I enter "testImage.png" as image field
    And I enter "19.99" as buyNow price field
    And I press the submit button
    Then I should see the new art displayed with buyNow