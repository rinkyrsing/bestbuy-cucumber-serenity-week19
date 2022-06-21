@Services
Feature: Services End Point
  As a user I want to test CRUD operation on services end points

  Background:
    Given I am on homepage of services

  Scenario: I should read all services data
    When  I send a GET request to the services endpoint
    Then  I should get a valid response code 200 from services endpoint

  Scenario: I should a new create services on services end point
    When  I send a POST request with a valid payload to the services endpoint
    Then  I should get a valid response code 201 from services endpoint

  Scenario: I should read a new services information on services end point
    When  I send a GET request to newly created services with product ID
    And   I should get a valid response code 201 from services endpoint
    Then  I verify if the services is services with correct details

  Scenario: I update a newly created services on services end point
    When  I send a PUT request to newly created services with product ID
    And   I should get a valid response code 201 from services endpoint
    Then  I verify if the services details is updated with correct details

  Scenario: I delete a newly created services on services end point
    When  I send a DELETE request to newly created services with product ID
    And   I should get a valid response code 201 from services endpoint
    Then  I verify if the services is deleted