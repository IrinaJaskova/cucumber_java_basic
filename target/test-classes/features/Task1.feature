#In Task1.feature create 1 scenario outline and 1 scenario for page with url: "https://kristinek.github.io/site/tasks/enter_a_number"

#Scenario outline for error cases:
#enter number too small
#enter number too big
#enter text instead of the number
#Scenario for correct number
Feature: Task 1
  As a test engineer
  I want to be able to test "Enter a number" page for errors

  Background:
    Given I am on Number page


  Scenario Outline: Scenario for error cases
    When I enter number: <number>
    And I click Submit button
    Then I see error message
    Examples:
      | number |
      | 3      |
      | 123    |
      | test   |


  Scenario: a new scenario for correct number
    When I enter number: 64
    And I click Submit button
    Then I see alert message with square root of 64
    And I close alert message

