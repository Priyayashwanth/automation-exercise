Feature: Add review on product

  Scenario: Add a review on a product
    Given I launch the browser
    When I navigate to url 'http://automationexercise.com'
    And I click on the 'Products' button
    Then I should be on the ALL PRODUCTS page
    When I click on view product link for product '1'
    Then I verify that 'Write Your Review' is visible
    And I enter my name, email, and review
    When I click the 'Submit' button
    Then I verify that the success message 'Thank you for your review.' is visible
