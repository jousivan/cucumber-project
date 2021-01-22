@BuyProduct
Feature: Buy a product
  I want buy a product

  @BuyProduct
  Scenario: Buy product
    Given I want to access the application
    And I want buy a product
    When I access the menu DRESSES
    And I add to cart the first item
    And I Proceed to checkout (varias vezes)
    And I choose pay by bank wire
    And I confirm my order
    Then I check that my order was completed

