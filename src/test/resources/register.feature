Feature:
  Scenario Outline:Checking if register is succesful
    Given User is on the register page
    When user enters <username>
    And user enters <password>
    And user enters <first name>
    And user enters <last name>
    And user clicks the "login" button
    Then user should see the "User registered" message

    Examples:
      | username | password | first name | last name |
      | a        | a        | a          | a         |
        | b        | b        | b          | b         |