Feature: Flight Booking

  Scenario: Book cheapest flight successfully

    Given User launches BlazeDemo application

    When User selects departure city "Paris"

    And User selects destination city "Buenos Aires"

    And User clicks Find Flights

    And User selects the cheapest flight

    And User enters passenger details
        | Name        | Address | City | State       | ZipCode | CardNumber      | CardHolderName |
        | Kajal Yadav | Noida   | Pune | Maharashtra | 411014  | 123456784957858 | Kajal          |

    And User purchases the flight

    Then Booking confirmation page should be displayed successfully

    And Confirmation ID should be captured and saved to file