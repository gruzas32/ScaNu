Feature:
  Scenario Outline:Adding recipe with all fields filled
    Given User is on the recipes tab
    When user enters <recipe name>
    And user enters <description>
    And user clicks the "add" button
    Then user should see the "Recipe added" message

    Examples:
      | recipe name | description       |
      | koldunai    | alabai skanus     |
      | cesnkainis  | cesnakas ir medus |

    Scenario Outline:Attempting to add a recipe without filling the name field
    Given User is on the recipes tab
    When user does not enter <recipe name>
    And user enters <description>
    And user clicks the "add" button
    Then user should see the "Please fill all the fields" message

    Examples:
      | recipe name | description       |
      |             | alabai skanus     |
      |             | cesnakas ir medus |

    Scenario Outline:Attempting to add a recipe without filling the description field
    Given User is on the recipes tab
    When user enters <recipe name>
    And user does not enter <description>
    And user clicks the "add" button
    Then user should see the "Please fill all the fields" message

    Examples:
      | recipe name | description       |
      | koldunai    |                   |
      | cesnkainis  |                   |

    Scenario Outline:Attempting to add a recipe without filling any fields
    Given User is on the recipes tab
    When user does not enter <recipe name>
    And user does not enter <description>
    And user clicks the "add" button
    Then user should see the "Please fill all the fields" message

    Examples:
      | recipe name | description       |
      |             |                   |
      |             |                   |

    Scenario Outline:Attempting to add a recipe with a name that already exists
    Given User is on the recipes tab
    When user enters <recipe name>
    And user enters <description>
    And user clicks the "add" button
    Then user should see the "Recipe already exists" message

    Examples:
      | recipe name | description       |
      | koldunai    | alabai skanus     |
      | koldunai    | alabai skanus     |

    Scenario Outline:Attempting to add a recipe with a description that already exists
    Given User is on the recipes tab
    When user enters <recipe name>
    And user enters <description>
    And user clicks the "add" button
    Then user should see the "Recipe already exists" message

Examples:
      | recipe name | description       |
      | koldunai    | alabai skanus     |
      | cesnkainis  | alabai skanus     |

      Scenario Outline: Attempting to add a recipe where the name field is filled with spaces
    Given User is on the recipes tab
    When user enters <recipe name> spaces
    And user enters <description>
    And user clicks the "add" button
    Then user should see the "Please fill all the fields" message

    Examples:
      | recipe name | description       |
      |             | alabai skanus     |
      |             | cesnakas ir medus |

    Scenario Outline: Attempting to add a recipe where the description field is filled with spaces
    Given User is on the recipes tab
    When user enters <recipe name>
    And user enters <description> spaces
    And user clicks the "add" button
    Then user should see the "Please fill all the fields" message

    Examples:
      | recipe name | description       |
      | koldunai    |                   |
      | cesnkainis  |                   |




