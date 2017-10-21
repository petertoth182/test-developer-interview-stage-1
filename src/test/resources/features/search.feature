Feature: Search

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed

  @ui @pageobject @solution
  Scenario Outline: Should be able to search for a product from the drop-down menu
    Given John is viewing the Etsy landing page
    When he searches for a product from the drop-down menu like "<category>"
    And he searches for a product from the subcategory menu like "<subcategory>"
    And he searches for a product from the subsubcategory menu like "<subsubcategory>"
    Then the result should be displayed for that category
      # On Etsy, there are embedded dropdown lists and that is why I implemented this solution to be able to test some cases
    Examples:
      | category | subcategory | subsubcategory |
      | Home & Living | PET SUPPLIES | Pet Furniture |
      | Vintage | na | na |
      | Toys & Entertainment | na | Blank Books |

       # This is for "Shop by category" section on Etsy.com with categories (picture and a title)
  @ui @pageobject @solution
  Scenario: Should be able to search for a product from the category icons
    Given John is viewing the Etsy landing page
    When he searches for a product from the category icons
    Then the result should be displayed for that category

  @ui @pageobject @wip
  Scenario: Should be able to search for a product between custom price range
    Given John is viewing the Etsy landing page
    When he searches for a product between 10 and 50 euros
    Then the result should be displayed product betweem the given price range