Feature: Inventory Page Validations on SauceDemo

  Background:
    Given User is logged into SauceDemo with valid credentials

 @skip
  Scenario: Verify Inventory page is displayed with products
    When User lands on the Inventory page
    Then Inventory page title should be "Products"
    And At least one product should be displayed

  @regression
  Scenario: Verify sorting functionality from A to Z
    When User sorts the products by "Name (A to Z)"
    Then First product name should be "Sauce Labs Backpack"

 # @regression
 # Scenario: Verify sorting functionality from high to low price
  #  When User sorts the products by "Price (high to low)"
 #   Then First product price should be "$49.99"

  @sanity
  Scenario: Verify user can add and remove item from cart
    When User adds "Sauce Labs Backpack" to the cart
    Then Cart badge count should be "1"
    When User removes "Sauce Labs Backpack" from the cart
    Then Cart badge count should be "0"
