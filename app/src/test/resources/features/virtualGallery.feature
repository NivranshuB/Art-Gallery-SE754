Feature: VirtualGallery

  Background:
    Given Driver set up for virtual gallery page

  Scenario: Successfully getting title and photo for all the artworks
    Given I access virtual gallery page
    When I click on the art description button
    Then I should see title and photo of all the artworks displayed in a compact card