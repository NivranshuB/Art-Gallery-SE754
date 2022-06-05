Feature: Filter Artwork
  This feature UI tests the art-gallery page and its functionality to filter artwork by sale type and art type among
  other attributes.

  Background:
    Given Driver set up for art gallery page
    And Gallery populated with test artwork

  Scenario:
    Given I am currently on the art gallery page
    When I select the buy now filter option
    And I press the filter by sale type button
    Then I should see all the art pieces with a buy now

  Scenario:
    Given I am currently on the art gallery page
    When I select the auction filter option
    And I press the filter by sale type button
    Then I should see all the art pieces on auction