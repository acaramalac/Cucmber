@Login
Feature: Login to the system
  Here we will login the Wikipedia

#  Scenario: User can login using valid credentials
#    Given user is on main page
#    When user clicks opens login page
#    And user is redirected to Login page
#    And user enters the following credentials
#      | UserName  | Password |
#      | sniper342 |          |
#      |           | 123      |
#      | sniper342 | 82006521 |
#    Then user is redirected to the Welcome to Wikipedia page


  Scenario Outline: User can login using valid credentials using Scenario Outline
    Given user is on main page
    When user opens login page
    Then user is redirected to Login page
    And user enters <UserName> and <Password>
    Then <pageTitle> is displayed
    Then user is redirected to the Welcome to Wikipedia page

    Examples:
      | UserName  | Password | pageTitle                        |
      | sniper342 |          | Log in - Wikipedia               |
      |           | 123      | Log in - Wikipedia               |
      | sniper342 | 82006521 | Wikipedia, the free encyclopedia |

