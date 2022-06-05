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

  Scenario:
    Given I am currently on the art gallery page
    When I select the painting filter option
    And I press the filter by art type button
    Then I should see all the painting art pieces

  Scenario:
    Given I am currently on the art gallery page
    When I select the print filter option
    And I press the filter by art type button
    Then I should see all the print art pieces

  Scenario:
    Given I am currently on the art gallery page
    When I select the sculpture filter option
    And I press the filter by art type button
    Then I should see all the sculpture art pieces

  Scenario Outline:
    Given I am currently on the buy now art gallery page
    When I set the minimum price to <min>
    And I set the maximum price to <max>
    And I press the filter by price button
    Then I should see all the art pieces with a buy now in this range

    Examples:
      | min   | max       |
      | 0.0   | 100.0     |
      | 100.0 | 1000000.0 |
      | 100.0 | 200.0     |