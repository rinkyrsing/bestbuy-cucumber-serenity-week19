@categories
Feature: Categories End Point
  As a user I want to test CRUD operation on categories end points

  Background:
    Given I am on homepage of categories

  Scenario: I should read all categories data
    When  I send a GET request to the categories endpoint
    Then  I should get a valid response code 200 from categories endpoint

  Scenario: I should a new create category on categories end point
    When  I send a POST request with a valid payload to the categories endpoint
    Then  I should get a valid response code 201 from categories endpoint

  Scenario: I should read a new categories information on categories end point
    When  I send a GET request to newly created categories with product ID
    And   I should get a valid response code 201 from categories endpoint
    Then  I verify if the categories is created with correct details

  Scenario: I update a newly created categories on categories end point
    When  I send a PUT request to newly created categories with product ID
    And   I should get a valid response code 201 from categories endpoint
    Then  I verify if the categories details is updated with correct details

  Scenario: I delete a newly created categories on categories end point
    When  I send a DELETE request to newly created categories with product ID
    And   I should get a valid response code 201 from categories endpoint
    Then  I verify if the categories is deleted