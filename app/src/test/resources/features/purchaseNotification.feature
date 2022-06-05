Feature: Purchase Notification

Background:
    Given Driver set up for Purchase Notification

    Scenario: Successfully purchasing an artwork
        Given I want to buy an artwork now
        When I purchase an item
        Then I want a notification to confirm my successful purchase
