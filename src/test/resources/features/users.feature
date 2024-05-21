Feature: HTTP Client Demo

  Scenario: Retrieve users data
    Given I send a GET request to the API endpoint "getUsers"
    Then I print the GET response

  Scenario: Add user data
    Given I send a POST request to the API endpoint "postUser" with JSON payload from "postPayload"
    Then I print the POST response

  Scenario: Update user data
    Given I send a PATCH request to the API endpoint "patchUser" with JSON payload from "patchPayload"
    Then I print the PATCH response

  Scenario: Delete user with ID 3
    Given I send a DELETE request to the API endpoint "deleteUser3"
    Then I print the DELETE response

  Scenario: Update email ID of user with ID 5
    Given I send a PUT request to the API endpoint "putUser5" with JSON payload from "putPayload"
    Then I print the PUT response
