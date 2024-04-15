Feature: User Registration

  Scenario: Successful User Registration
    Given the user is on the registration page
    When the user enters a valid username, password, first name, and last name
    And the user clicks the "register" button
    Then the user should receive a confirmation message
    And the user should be redirected to the login page

  Scenario: Attempting to Register with Empty Fields
    Given the user is on the registration page
    When the user attempts to register without filling in any fields
    Then the user should see an alert message prompting to fill all fields

  Scenario: Attempting to Register with Existing Username
    Given the user is on the registration page
    And there exists a user with the same username in the database
    When the user attempts to register with the existing username
    Then the user should see an alert message indicating that the username is already taken

  Scenario: Registering with Missing Username
    Given the user is on the registration page
    When the user attempts to register without entering a username
    Then the user should see an alert message indicating to fill all fields

  Scenario: Registering with Missing Password
    Given the user is on the registration page
    When the user attempts to register without entering a password
    Then the user should see an alert message indicating to fill all fields

  Scenario: Registering with Missing First Name
    Given the user is on the registration page
    When the user attempts to register without entering a first name
    Then the user should see an alert message indicating to fill all fields

  Scenario: Registering with Missing Last Name
    Given the user is on the registration page
    When the user attempts to register without entering a last name
    Then the user should see an alert message indicating to fill all fields

  Scenario: Back to Login Page
    Given the user is on the registration page
    When the user clicks the "back to login" button
    Then the user should be redirected to the login page
