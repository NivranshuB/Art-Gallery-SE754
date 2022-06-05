Feature: Bid on Artwork
  This feature tests to ensure users who bid on auctioned artworks are registered and older than 16 to allow buying.

  Background:
    Given I am presently on the details page for a piece of art

  Scenario: User not logged in
    Given I want to buy an artwork
    When I click the Bid button
    And I am not logged in
    Then Deny the Bid attempt
    And Notify me to sign up or sign in

  Scenario: User logged in
    Given I am logged in
    When I click the Bid button
    Then Allow the Bid attempt

  Scenario Outline: User is too young
    Given I am <age> years
    When I click the Bid button
    Then Deny the Bid attempt
    And Tell me that I am too young
    Examples:
      |age|
      |"7"  |
      |"12" |
      |"15" |

  Scenario: User is old enough
    Given I am "23" years old
    When I click the Bid button
    Then Allow the Bid attempt