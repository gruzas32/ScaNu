Feature:
  Scenario Outline:Checking if recipe is deleted from list
    Given User is on the recipes tab
    When user clicks on selected recipe from list
    And user clicks the "delete" button
    Then user should see the "Recipe deleted" message

    Examples:
      |  |  |
      |  |  |
      |  |  |