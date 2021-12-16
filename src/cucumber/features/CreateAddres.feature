Feature: Create Address

  Scenario Outline: adding a new address
    Given user logged in address page
    When creating a new address
    Then filling in the address form with data "<alias>" "<street>" "<city>" "<zipCode>" "<country>" "<phone>"
    And checking the correctness of the new address
    #Then delete address you just created

    Examples:
      | alias           | street  | city     | zipCode | country          | phone    |
      | another address | Polna   | Warszawa | 01-001  | United Kingdom   | 60199222 |
