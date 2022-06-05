Feature: Shipping Details

  Background:
    Given Driver set up for shipping details page

  Scenario: Successfully getting a user to enter shipping details
    Given I have clicked to buy and an artwork
    When I click on the share button
    Then I want to generate a link of the art piece to share
