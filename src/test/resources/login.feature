Feature:Testing login functionality
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

    Scenario:Checking if login is unsuccesful (incorrect username)
    Given: User is on the login page.
    When: User enters an incorrect <username>.
    And: User enters a valid <password>.
    And: User clicks the "login" button.
    Then: User should see an error message indicating that the username is incorrect.

      Examples:
        | username | password |
        | b        | a        |
        | bdmin    | admin    |

  Scenario:Checking if login is unsuccesful (incorrect password)
  Given: User is on the login page.
  When: User enters an valid <username>.
  And: User enters a incorrect <password>.
  And: User clicks the "login" button.
  Then: User should see an error message indicating that the password is incorrect.

    Examples:
      | username | password |
      | a        | b        |
      | admin    | bdmin    |

  Scenario:Checking if login is unsuccesful (blank fields)
  Given: User is on the login page.
  When: User enters an blank <username>.
  And: User enters a blank <password>.
  And: User clicks the "login" button.
  Then: User should see an error message indicating that the username and password  is incorrect.
    Examples:
      | username | password |
      |          |          |
      |          |          |

  Scenario:Checking if login is unsuccesful (blank username)
  Given: User is on the login page.
  When: User enters an blank <username>.
  And: User enters a valid <password>.
  And: User clicks the "login" button.
  Then: User should see an error message indicating that the username and password  is incorrect.
    Examples:
      | username | password |
      |          | b        |
      |          | bdmin    |

  Scenario:Checking if login is unsuccesful (blank password)
  Given: User is on the login page.
  When: User enters an valid <username>.
  And: User enters a blank <password>.
  And: User clicks the "login" button.
  Then: User should see an error message indicating that the username and password  is incorrect.
    Examples:
      | username | password |
      | a        | b        |
      | admin    | bdmin    |