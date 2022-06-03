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

  Scenario: Add art with Auction
    Given I am on the add art page
    When I enter "Title" as title field
    And I enter "Description" as description field
    And I select "1" as art type
    And I enter "2x1m" as dimension field
    And I enter "artist" as artist name field
    And I enter "testImage.png" as image field
    And I enter "19.99" as auction start price field
    And I enter "50" as auction reserve price field
    And I enter "7" as auction time remaining field
    And I press the submit button
    Then I should see the new art displayed with auction

  Scenario: Add art with both Buy Now and Auction
    Given I am on the add art page
    When I enter "Title" as title field
    And I enter "Description" as description field
    And I select "1" as art type
    And I enter "2x1m" as dimension field
    And I enter "artist" as artist name field
    And I enter "testImage.png" as image field
    And I enter "19.99" as buyNow price field
    And I enter "19.99" as auction start price field
    And I enter "50" as auction reserve price field
    And I enter "7" as auction time remaining field
    And I press the submit button
    Then I should see the new art displayed with buyNow

  Scenario Outline: Add art with invalid inputs
    Given I am on the add art page
    When I enter <title> as title field
    And I enter <description> as description field
    And I select <artType> as art type
    And I enter <dimensions> as dimension field
    And I enter <artist> as artist name field
    And I enter <image> as image field
    And I press the submit button
    Then I should see error message
    Examples:
      | title   | description    | artType | dimensions | artist   | image              |
      | ""      | ""             | ""      | ""         | ""       | ""                 |
      | "title" | "descriptions" | "2"     | "2x1m"     | "artist" | "invalidImage.png" |
      | "title" | "descriptions" | "3"     | "2x1m"     | "artist" | "testImage.png"    |