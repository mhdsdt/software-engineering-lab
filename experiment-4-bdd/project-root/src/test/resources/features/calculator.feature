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