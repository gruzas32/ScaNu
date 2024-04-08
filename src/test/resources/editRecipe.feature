Feature:
  Scenario Outline:Checking if recipe edits are saved
    Given User is on the recipes tab
    When user enters <recipe name>
    And user enters <description>
    And user clicks the "edit" button
    Then user should see the "Recipe edited" message

    Examples:
      | recipe name | description       |
      | koldunai    | alabai skanus     |
      | cesnkainis  | cesnakas ir medus |