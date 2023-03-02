@Task
Feature: Login to HRM

  Scenario: Valid Login
    Given user is logged in with valid credentials
    Given I navigated to the HRM website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that i am logged in

  Scenario: invalid password
    Given user enter valid username
    Given user enter invalid password
    And user click login button
    Then I validate that invalid credential is displayed
