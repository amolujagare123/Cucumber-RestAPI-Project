Feature: All application related scenarios

  @sampleUser
  Scenario: Verify user is created successfully
    Given Add User Payload for is created
    When user calls "AddUser" with "POST" http request
    Then the API call got success with status code “200”
