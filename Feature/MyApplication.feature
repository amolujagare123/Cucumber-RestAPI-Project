Feature: All application related scenarios

  @sampleUser
  Scenario: Verify user is created successfully
    Given Add User Payload for is created
    When user calls "AddUser" with "POST" http request
    Then the API call got success with status code “201”


  @chatUserUpadte
  Scenario: Verify user is updated successfully
    Given update User Payload for is created
    When user calls UpdateUser with "PUT" http request
    Then the update user API call got success with status code "200"
    Then "error" should be "false";


  @chatUserCreate
  Scenario Outline: Verify user is created successfully
    Given Create chat User Payload with <user> , <pass> , <email> ,<name> ,<surname> ,<nickname>
    When user calls create with POST http request
    Then the create user API call got success with status code "200"
   # Then "error" should be "false";
    Examples:
      | user    | pass     | email             | name     | surname     | nickname     |
      | user-91 | pass-91  | user-91@email.com | name-91  | surname-91  | nickname-91  |
      | user-92 | pass-92  | user-92@email.com | name-92  | surname-92  | nickname-92  |
      | user-93 | pass-93  | user-93@email.com | name-93  | surname-93  | nickname-93  |


