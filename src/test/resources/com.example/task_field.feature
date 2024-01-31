Feature: Task field functionality

  @negative
  Scenario: After changes, the task is displayed incorrectly
    Given user enter main page
    And enters task "write a program" and presses Enter key
    When user clicks change button
    And enters task " with java" and presses Enter key
    Then the task is changed to "write a progra..."

  @positive
  Scenario: Testing the ability to mark a task as completed
    Given user enter main page
    And enters following tasks
      | task                   |
      | write a program        |
      | Englisch lernen        |
      | alle Hindernisse überwinden |
      | Fehler korrigieren          |
      | ein Programm schreiben |
      | write a program        |
    When user clicks complete button in the first 3 tasks
    Then a status of tasks are changed to completed

  @positive
  Scenario: Checking the task filter
    Given user enter main page
    And enters following tasks
      | task                   |
      | write a program        |
      | Englisch lernen        |
      | alle Hindernisse überwinden |
      | Fehler korrigieren          |
      | ein Programm schreiben |
      | write a program        |
    And user clicks complete button in the first 3 tasks
    When user clicks a filter button and select completed
    Then Only completed tasks will be displayed