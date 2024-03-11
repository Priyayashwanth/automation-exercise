Feature: Logout User

  Scenario: Successful logout of user
    Given I launch the browser
    When I navigate to url 'http://automationexercise.com'
    Then I verify that the home page is visible successfully
    When I click on the 'Signup / Login' button
    Then I verify that 'Login to your account' is visible
    When I enter correct email address and password
    And I click the 'Login' button
    Then I verify that 'Logged in as' is visible
    When I click on the 'Logout' button
    Then I verify that the user is navigated to the login page
