Feature: Purchase

  @purchase @pageobject @wip
  Scenario: Should be able to put a product in the cart and buy it
    Given John is viewing the Etsy landing page
    When he signs in
      And he puts a product in the cart
        And he buys it
    Then the result should be that he was able to buy the product