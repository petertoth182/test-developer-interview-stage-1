Feature: Etsy API

  @api @users @wip
  Scenario Outline: Find Users Profile
    Given I have a user's id: "<userid>"
    When I request Etsy api to find the users profile
    Then I should get the users profile: "<username>"

    Examples:
      | userid  | username  |
      | 12345   | john      |

  @api @listings @wip
  Scenario: To retrieve the most recent active listings
    Given Etsy's API is up and running
    When I try to retrieve the most recent active listings
    And I should get the the most recent active listings