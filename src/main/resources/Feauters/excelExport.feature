Feature: Export results to .xlsx file
  Here we will import filtered results to an excel file

  Scenario Outline: User is able to import results to .xlsx
    Given user is on search page
    When user enters <searchKeyWords>
    And user gets search results
    Then filtered results are imported to excel file

    Examples:
      | searchKeyWords     |
      | exception handling |





#    refactor importToExcelMetod:
#  1. parametherize this test (add two more search words)
#  2. for every searchKey words create a separate excel
#  3. parametherize nummber of results to filter and add to excel (may be 50, may be 40, 3,...)

#  learn:
#    Regex
#    xpath
#    css selectors!!!
#
#    Mocha
#    Git