Feature: Google search
@Task
  Scenario: Search by typing
    Given I navigated to Google.
    When I type something on the search box
    And I click on the search button
    Then I can see the results of my search
    And I can count the number of the results
