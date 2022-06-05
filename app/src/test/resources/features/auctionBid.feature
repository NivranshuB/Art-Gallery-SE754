Feature: Bid on Artwork
  This feature tests to ensure users who bid on auctioned artworks are registered and older than 16 to allow buying.

  Background:
    Given I am on the details page for a piece of art

  Scenario: User not logged in
    When I click the Bid button
    And I am not logged into an account
    Then Deny the Bid attempt
    And Notify me to sign up or sign in

  Scenario: User logged in
    Given I am logged into an account
    When I click the Bid button
    Then Allow the Bid attempt

  Scenario Outline: User is too young
    Given I am <age> years old
    When I click the Bid button
    Then Deny the bid attempt
    And Notify me that I am too young
    Examples:
      |age|
      |"7"  |
      |"12" |
      |"15" |

  Scenario: User is old enough
    Given I am "23" years old
    When I click the Bid button
    Then Allow the bid to take place