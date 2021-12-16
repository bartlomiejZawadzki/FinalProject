Feature: Deleting Last Address

  Scenario: Deleting last address
    Given logged in address page
    When deleting last added address
    Then back to main page