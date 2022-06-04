Feature: Purchase Notification

    Scenario: Successfully purchasing an artwork
        Given I want to buy an artwork now.
        When I purchase the item.
        Then I want a notification to confirm my successful purchase.
