Feature: Internal fields functionality

  @positive
  Scenario: Testing the ability to change a style
    Given user enter internal page
    When user clicks palette button
    And clicks style change to bumblebee
    Then theme of internal page is changed

  @positive
  Scenario: Testing the link of author
    Given user enter internal page
    When user clicks to author link
    Then user goes to the author's page