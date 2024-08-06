Feature: Car Simulation

  Scenario: Single car simulation
    Given a field of 10 by 10
    And a car "A" at position 1 2 facing N with commands "FFRFFFFRRL"
    When the simulation runs
    Then the car "A" should be at position 5 4 facing S

  Scenario: Multiple car simulation with collision
    Given a field of 10 by 10
    And a car "A" at position 1 2 facing N with commands "FFRFFFFRRL"
    And a car "B" at position 7 8 facing W with commands "FFLFFFFFFF"
    When the simulation runs
    Then there should be a collision between car "A" and car "B" at position 5 4 at step 7
