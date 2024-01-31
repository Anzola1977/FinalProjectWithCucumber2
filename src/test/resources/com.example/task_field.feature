Feature: Task field functionality

  @positive
  Scenario: Checking task field clickability
    Given user enter main page
    And enters task "write a program" and presses Enter key
    When user clicks this task
    Then the task field changes color to "lightgoldenrodyellow" and trash icon appears

  @positive
  Scenario: Checking the ability to change the task
    Given user enter main page
    And enters task "write a program" and presses Enter key
    And clicks submit button
    When user clicks this task, enters " with java" and presses Enter key
    Then the task is changed to "write a program with java"

  @positive
  Scenario: Testing the ability to mark a task as completed
    Given user enter main page
    And enters task "write a program" and presses Enter key
    When user clicks icon button
    Then a checkmark appears
    And the text color changes to gray and crossed out

  @positive
  Scenario Outline: Checking the task counter
    Given user enter main page
    And user clicks in the task input field
    And user enters tasks "<task>" and clicks submit button
    When user clicks icon button in all tasks
    Then the counter of marked tasks will be equal to the number of tasks

    Examples:
      | task                   |
      | write a program        |
      | ein Programm schreiben |
      | write a program        |

  @negative
  Scenario Outline: The text color of previously marked tasks is displayed incorrectly
    Given user enter main page
    And user clicks in the task input field
    And user enters tasks "<task>" and clicks submit button
    And user clicks icon button in all tasks
    When user clicks in the task input field
    And enters task "write a program" and presses Enter key
    Then the text color of previously marked tasks becomes black and is not crossed out

    Examples:
      | task                   |
      | write a program        |
      | ein Programm schreiben |
      | write a program        |