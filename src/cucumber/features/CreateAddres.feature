Feature: Create Address

  Scenario Outline: user can search any keyword
    Given user logged in and at the address page
    When clicking the link Create a new address
    Then fill out and save the form "<alias>" "<street>" "<city>" "<zipCode>" "<country>" "<phone>"
    And check if the newly created address "<alias>" is correct
    #Then delete address you just created

    Examples:
      | alias           | street  | city     | zipCode | country          | phone    |
      | another address | Polna   | Warszawa | 01-001  | United Kingdom   | 60199222 |
