Feature:
  Scenario Outline:Checking if login is succesful
    Given User is on the login page
    When user enters <username>
    And user enters <password>
    And user clicks the "login" button
    Then user should see the "shop" page

    Examples:
      | username | password |
      | a        | a        |
      | admin    | admin    |