Feature: SauceDemo Checkout Functionality
@sanity
Scenario: Complete checkout after adding product
    Given User is on SauceDemo login page
    When User logs in with username "standard_user" and password "secret_sauce"
    And User adds a product to the cart
    And User navigates to cart and proceeds to checkout
    And User provides checkout details "Akanksha" "Sharma" "411001"
    Then Payment information, shipping info and total should be correct
    And User completes the order
    Then User should see confirmation message "Thank you for your order!"
