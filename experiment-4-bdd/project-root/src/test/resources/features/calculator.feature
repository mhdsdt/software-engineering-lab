Feature: Calculator
  Scenario: Calculate the square root of a divided by b
    Given Two input values, 4 and 1
    When I calculate the square root of a divided by b
    Then I expect the result 2

  Scenario Outline: Calculate the square root of a divided by b
    Given Two input values, <a> and <b>
    When I calculate the square root of a divided by b
    Then I expect the result <result>
    Examples:
      | a  | b  | result |
      | 4  | 1  | 2      |
      | 36 | 4  | 3      |

  Scenario: Calculate the square root of a divided by b with negative values
    Given Two input values, -4 and 1
    When I calculate the square root of a divided by b
    Then I expect the result NaN

  Scenario: Calculate the square root of a divided by b with zero
    Given Two input values, 0 and 1
    When I calculate the square root of a divided by b
    Then I expect the result 0

  Scenario: Calculate the square root of a divided by b with large values
    Given Two input values, 10000 and 100
    When I calculate the square root of a divided by b
    Then I expect the result 10
