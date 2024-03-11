Feature: Contact Us Form

  Scenario: Submitting Contact Us Form
    Given I launch the browser
    When I navigate to url 'http://automationexercise.com'
    Then I verify that the home page is visible successfully
    When I click on the 'Contact us' button
    Then I verify that 'Get In Touch' is visible
    When I enter name, email, subject, and message
    And I upload a file
    And I click on 'submit-button'
    And I click on OK from the alert
    Then I verify that the success message 'Success! Your details have been submitted successfully.' is visible
    When I click on the 'Home' button
    Then I verify that the home page is visible successfully
