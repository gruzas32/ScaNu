Feature:
  Scenario Outline:Checking if recipe is added to list
    Given User is on the recipes tab
    When user enters <recipe name>
    And user enters <description>
    And user clicks the "add" button
    Then user should see the "Recipe added" message

    Examples:
      | recipe name | description       |
      | koldunai    | alabai skanus     |
      | cesnkainis  | cesnakas ir medus |