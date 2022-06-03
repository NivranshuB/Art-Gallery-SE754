Feature: Share Artist

  Scenario: Successfully getting an artist link to share
    Given I access an artist's profile page
    When I click on the share artist button
    Then I want to generate a link of the artist profile to share
