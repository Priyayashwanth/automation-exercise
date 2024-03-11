Feature: User Registration

  Scenario: Register a new user
    Given I launch the browser
    When I navigate to url 'http://automationexercise.com'
    Then I verify that the home page is visible successfully
    And I click on the 'Signup / Login' button
    And I verify that 'New User Signup!' is visible
    And I enter the name and email address
    And I click the 'Signup' button
    And I verify that 'Enter Account Information' is visible
    And I fill in the details: Title, Password, Date of birth
    And I select the checkbox 'Sign up for our newsletter!'
    And I select the checkbox 'Receive special offers from our partners!'
    And I fill in the additional details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And I click the 'Create Account' button
    Then I verify that 'Account Created!' is visible
    And I click on the 'Continue' button
    And I verify that 'Logged in as' is visible
    And I click on the 'Delete Account' button
    Then I verify that 'Account Deleted!' is visible
    And I click on the 'Continue' button
