Feature: All application related scenarios

  @sampleUser
  Scenario: Verify user is created successfully
    Given Add User Payload for is created
    When user calls "AddUser" with "POST" http request
    Then the API call got success with status code “201”


  @chatUserUpadte
  Scenario: Verify user is updated successfully
    Given update User Payload for is created
    When user calls "createUserAPI" with "PUT" http request  with pathParam "9"
    Then the API call got success with status code "200"
    Then "error" should be "false";


  @chatUserCreate
  Scenario Outline: Verify user is created successfully
    Given Create chat User Payload with <user> , <pass> , <email> ,<name> ,<surname> ,<nickname>
    When user calls "createUserAPI" with "POST" http request  with pathParam ""
    Then the API call got success with status code "200"
    Then "error" should be "false";
    Examples:
      | user    | pass     | email             | name     | surname     | nickname     |
      | user-94 | pass-91  | user-91@email.com | name-91  | surname-91  | nickname-91  |
      | user-95 | pass-92  | user-92@email.com | name-92  | surname-92  | nickname-92  |
      | user-96 | pass-93  | user-93@email.com | name-93  | surname-93  | nickname-93  |


  @chatUserGet
  Scenario: Verify user is displayed successfully
    Given Get User request is created
    When user calls "getUserAPI" with "GET" http request  with pathParam "1"
    Then the API call got success with status code "200"
    Then "error" should be "false";
    Then "result.email" should be "amolujagare@gmail.com";

  @chatUserDelete
  Scenario: Verify user is displayed successfully
    Given delete User request is created
    When user calls "deleteUserAPI" with "DELETE" http request  with pathParam "7"
    Then the API call got success with status code "200"
    Then "error" should be "false";


  @chatUserCreateDelete
  Scenario Outline: Verify user is created successfully
    Given Create chat User Payload with <user> , <pass> , <email> ,<name> ,<surname> ,<nickname>
    When user calls "createUserAPI" with "POST" http request  with pathParam ""
    Then the API call got success with status code "200"
    Then "error" should be "false";
    When delete User request is created
    When user calls "deleteUserAPI" with "DELETE" http request with same user
    Then the API call got success with status code "200"
    Then "error" should be "false";

    Examples:
      | user    | pass     | email             | name     | surname     | nickname     |
      | user-71 | pass-91  | user-91@email.com | name-91  | surname-91  | nickname-91  |