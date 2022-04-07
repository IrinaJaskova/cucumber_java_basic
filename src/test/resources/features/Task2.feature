#In Task2.feature create 1 scenario outline and create scenario or scenario outlines for
# page https://kristinek.github.io/site/tasks/list_of_people.html
# or https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html in order to test that user can:

#add a new person
#edit a person
#remove a person
#reset original list after:
#adding a person
#editing a person
#removing a person
#check that clear button on adding a user works correctly

Feature: Task 2
  As a test engineer
  I want to be able to test "People" page for adding, editing and removing person

  Background:
    Given I am on People with jobs page


  Scenario Outline: scenario for adding a new person
    When I click Add person button
    And I set name on Add page: "<name>"
    And I set job on Add page: "<job>"
    Then I click Add button
    And I check new person added with "<name>" and "<job>"
    And I reset list
    Examples:
      | name | job    |
      | John | Driver |

  Scenario: scenario for editing a person
    When I click Edit person button
      | name | Jane |
    And I set new name and job on Edit page
      | name | Janett |
      | job  | seller |
    Then I click Edit button
    And I check person data changed
      | name | Janett |
      | job  | seller |
    And I reset list

  Scenario: scenario for removing a person
    When I click Delete person button
      | Jane |
    Then I check person is deleted
      | Jane |
    And I reset list

  Scenario Outline: scenario to check Clear All button
    When I click Add person button
    And I set name on Add page: "<name>"
    And I set job on Add page: "<job>"
    Then I click Clear all Fields button
    And I check all fields are empty
    Examples:
      | name | job    |
      | John | Driver |