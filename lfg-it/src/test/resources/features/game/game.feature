Feature: Games

  Scenario: Game creation
    When the following game is created
      | UNO | a shitty game | 2 | 8 |
    Then the response has status code 201