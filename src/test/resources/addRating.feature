Feature:
  Scenario Outline:Checking if recipe rating is added succesfully
    Given User is on the recipe rating page
    When user selects recipe from list
    And user enters <comment>
    And user clicks <rating(1-5)>
    And user clicks the "sent" button
    Then user should see the "Rating added" message

    Examples:
      | recipe             | comment | rating |
      | Burekeliu sriuba   | skanus  | a      |
      | Tarkuotas tarkanas | saldus  | b      |