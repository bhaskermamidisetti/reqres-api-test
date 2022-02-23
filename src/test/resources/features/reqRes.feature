@reqres
Feature: ReqRes - Register, Login and Get the registered user details

  As API admin
  I want to register, login and get registered user details

  @sanity
  Scenario Outline: Registered the user and Login with the registered email address
    Given ReqRes Customer register using POST request with "<email>" and "<password>"
    Then Login with registered user using POST request with "<email>" and "<password>"
    And Get the list of registered users
    And Get the list of resources

    Examples:
      | email | password |
      | george.bluth@reqres.in | pistol |
      | janet.weaver@reqres.in | pistol |

  @sanity
  Scenario: Read Data from JSON
    Given Read Data from given Json
    Then assert the data