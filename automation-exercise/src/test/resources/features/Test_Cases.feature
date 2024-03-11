Feature: Verify Test Cases Page

  Scenario: Navigate to Test Cases Page
    Given I launch the browser
    When I navigate to url 'http://automationexercise.com'
    Then I verify that the home page is visible successfully
    When I click on the 'Test Cases' button
    Then I verify that the user is navigated to the test cases page successfully
