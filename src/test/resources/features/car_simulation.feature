Feature: Car Simulation

  Scenario: Single car simulation
    Given a field of width 10 and height 10
    And a car named "A" at position 1 2 facing "N"
    When the car executes commands "FFRFFFFRRL"
    Then the final position of the car should be 5 4 "S"