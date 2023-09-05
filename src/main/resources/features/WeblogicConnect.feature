@SmokeTest
Feature: Fetch table data from Weblogic console

  Scenario Outline: Fetch data from the table
    Given I navigate to "<url>"
    And I enter "<username>" in the username field
    And I enter "<password>" in the password field
    And I click the login button
    When I fetch the table data for "weblogicProject"
    When I fetch the table data for "Weblogic-Deployment"
    Then I display the output value
    When I enter in datasource "JDBC Data Source-0"
    And I fetch the data source table data for "AdminServer"
    Then I display the data source output value

    Examples: 
      | url                           | username | password  |
      | http://localhost:7001/console | weblogic | Patil@007 |
