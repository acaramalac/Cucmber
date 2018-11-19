Feature: Export results to .xlsx file
  Here we will import filtered results to an excel file

  Scenario Outline: User is able to import results to .xlsx
    Given user is on search page
    When user introduces <searchKeyWords>
    And user gets search results
    Then a <number> of results are filtered and imported to excel file

    Examples:
      | searchKeyWords     | number |
#      | exception handling | 70     |
#      | Barbra Streisand   | 20     |
      | 99 Bottles of Beer | 400    |
#      | Expendables        | 250    |


#    refactor all xpaths to css selectors

#    refactor importToExcelMetod:
#  1. parametherize this test (add two more search words)
#  2. for every searchKey words create a separate excel
#  3. parametherize number of results to filter and add to excel (may be 50, may be 40, 3,...)

#  learn:
#    Regex
#    xpath
#    css selectors!!!
#
#    Mocha
#    Git