@Login
Feature: Checking Argument Transformation
  This feature is designed in order to test Argument Transformation and use it in tests

  Scenario: I check if my code works
    Given user is on main page
    When user opens login page
    And I enter user's email: vasilii.pupkin
    And I verify the number of his emails in digits 1000
    Then user is redirected to the Welcome to Wikipedia page
