Feature: Etsy account

  @ui @pageobject @wip
  Scenario: Should be able to sign in from the landing page
    Given John is viewing the Etsy landing page
    When he tries to sign in
    Then the result shouldb be that he is signed in

  @ui @pageobject @wip
  Scenario: Should be able to sign in from the landing page with wrong credentials
    Given John is viewing the Etsy landing page
    When he tries to sign in with wrong credentials
    Then the result should be that he wasn't able to log in

  @ui @pageobject @wip
  Scenario: Should be able to register from the landing page
    Given John is viewing the Etsy landing page
    When he tries to register
    Then the result should be that he was able to register
