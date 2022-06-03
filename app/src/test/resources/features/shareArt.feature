Feature: Share Art

    Scenario: Successfully getting an art link to share
        Given I access an art details page
        When I click on the share button
        Then I want to generate a link of the art piece to share
