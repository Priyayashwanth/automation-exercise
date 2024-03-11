Feature: Register User with existing email

  Scenario: Registering a user with an existing email address
    Given I launch the browser
    When I navigate to url 'http://automationexercise.com'
    Then I verify that the home page is visible successfully
    When I click on the 'Signup / Login' button
    Then I verify that 'New User Signup!' is visible
    When I enter a name and an already registered email address
    And I click the 'Signup' button
    Then I verify that the error message 'Email Address already exist!' is visible
