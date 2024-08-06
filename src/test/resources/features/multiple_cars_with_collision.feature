Feature: Multiple Cars with Collision

  Scenario: Multiple cars collision detection
    Given a field of 10 10
    And a car named "A" at positions 1 2 facing "N"
    And a car named "B" at positions 7 8 facing "W"
    When the cars execute commands "FFRFFFFRRL" and "FFLFFFFFFF"
    Then the collision should occur between "A" and "B" at position 5 4 at step 7
