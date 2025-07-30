Feature: SauceDemo End-to-End Flow

  Background:
    Given User is on SauceDemo login page

  Scenario: Valid login with standard user
    When User enters username "standard_user" and password "secret_sauce"
    And Clicks on login button
    Then User should be navigated to inventory page

  Scenario: Add single product to cart and checkout
    When User logs in with username "standard_user" and password "secret_sauce"
    And Adds product "Sauce Labs Backpack" to cart
    And Clicks on cart icon
    And Clicks on checkout button
    And Enters checkout details with first name "Test", last name "User", and postal code "12345"
    And Clicks on continue button
    And Clicks on finish button
    Then Order confirmation page is displayed

  Scenario: Add multiple products to cart
    When User logs in with username "standard_user" and password "secret_sauce"
    And Adds product "Sauce Labs Backpack" to cart
    And Adds product "Sauce Labs Bike Light" to cart
    And Clicks on cart icon
    Then Cart should display 2 products

  Scenario: Login with invalid credentials
    When User enters username "invalid_user" and password "invalid_pass"
    And Clicks on login button
    Then Error message should be displayed
