Feature: The task input field functionality

  @positive
  Scenario Outline: Input scenarios with submit button
    Given user enter main page
    When user enters tasks "<tasks>" and date "<date>"
    And clicks submit button
    Then user's task is added to his task list

    Examples:
      | tasks                  | date       |
      | write a program        | 23.04.1995 |
      | ein Programm schreiben | 12-2005-21 |
      | write a program        | 23/14/23   |
      | 12345677               | 2024.12.35 |
      | /*%;:+                 |            |
      | 0                      | 00000000   |
      | 12.45                  | 00.00.0000 |

  @positive
  Scenario: Input scenario with Enter key
    Given user enter main page
    When user clicks in the task input field
    And enters task "программирование" and presses Enter key
    Then user's task is added to his task list

  @negative
  Scenario: Input scenarios with empty field
    Given user enter main page
    When user enters tasks "" and date ""
    And clicks submit button
    Then user's task is not added to his task list
    And an error message appears

  @negative
  Scenario: The task input field is not available for input
    Given user enter main page
    When user inputs task "write a code of program" and clicks the submit button 13 times
    Then tasks are added to task list
    And the task input field is no longer available