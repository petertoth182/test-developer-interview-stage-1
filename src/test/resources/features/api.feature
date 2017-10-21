Feature: Etsy API

  @api @login @wip
  Scenario: Sign in with Etsy API
    Given I have John's username and password
    When I request Etsy api to sign in John
    Then I should get response status code 200
    And John should get logged in

  @api @login @wip
  Scenario: Sign in with Etsy API with wrong password
    Given I have John's username and his wrong password
    When I request Etsy api to sign in John
    Then I should get response status code 401
    And John shouldn't get logged in

  @api @registration @wip
  Scenario: Register a new account with Etsy API
    Given I have John's details
    When I request Etsy api to register a new account for John
    Then I should get response status code 200
    And John should get registered

  @api @wip
  Scenario: Basic search with Etsy API
    Given I have John's username and password
    When I request Etsy api to search for a product
    Then I should get response status code 200
    And I should get the result for my search