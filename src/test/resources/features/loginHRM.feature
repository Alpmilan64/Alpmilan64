Feature: Login to HRM

  @smoke
  Scenario: Valid Login
    Given user is logged in with valid credentials
    Given I navigated to the HRM website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that i am logged in
