Feature: task delete functionality

  @positive
  Scenario: Testing the ability to delete all tasks
    Given user enter main page
    And enters following tasks and dates
      | tasks                  | dates      |
      | write a program        | 14.05.2023 |
      | ein Programm schreiben | 17.08.2023 |
      | write a program        | 01.02.2024 |
    When user clicks delete button
    Then a task is deleted

  @positive
  Scenario: Deleting a task using the trash icon
    Given user enter main page
    And enters task "write a program" and presses Enter key
    When user clicks a trash icon in the task field
    Then a task is deleted