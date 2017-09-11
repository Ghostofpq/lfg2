Feature: Games

  Background:
    Given there is no game

  Scenario: Game creation
    When the following game is created
      | UNO | a shitty game | 2 | 8 |
    Then the response has status code 201

  Scenario: Game read
    Given the following game exists
      | UNO | a shitty game | 2 | 8 |
    When I search for a game named "UNO"
    Then the response has status code 200