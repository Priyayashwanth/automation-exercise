Feature: User Login

  Scenario: Login User with incorrect email and password
    Given I launch the browser
    When I navigate to url 'http://automationexercise.com'
    Then I verify that the home page is visible successfully
    And I click on the 'Signup / Login' button
    Then I verify that 'Login to your account' is visible
    When I enter incorrect email address and password
    And I click the 'Login' button
    Then I verify that the error message 'Your email or password is incorrect!' is visible
