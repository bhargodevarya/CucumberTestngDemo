Feature: API calls

  Scenario: Reading URL from props file
    Given I have a property in yml file
    When I read the props from the file
    Then I should be able to make a remote call and code is 200