@Search
Feature: Search using search form
  Here we will type two words for search

  Scenario Outline: User is able to search through search page
    Given user is logged in using <UserName> and <Password>
    When user opens search page
    And user enters <searchKeyWords>
    Then user gets search results

    Examples:
      | UserName  | Password | searchKeyWords     |
      | sniper342 | 82006521 | exception handling |
