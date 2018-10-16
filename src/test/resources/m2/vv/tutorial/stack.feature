Feature: Bounded stack

  A stack with bounded capacity.

  Scenario: Pushed value should be on top
    Given a new stack
    When 3 is pushed
    Then 3 should be on top

  Scenario: Created stack should be empty
    Given a new stack
    Then it should be empty

  Scenario: Two pushes
    Given a new stack
    When 1 is pushed
    And 2 is pushed
    Then it should have 2 elements

  Scenario: Push and pop
    Given a new stack
    When 1 is pushed
    But an element is popped
    Then it should be empty

  Scenario Outline: Element on top
    Given a new stack
    When <number> is pushed
    Then <number> should be on top

    Examples:
      | number |
      |    3   |
      |    4   |



