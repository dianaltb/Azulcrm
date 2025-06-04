@Profile
Feature: Profile page functionality.

  Agile story: As a user, I want to access my profile page.

  Background:
    Given user is logged into main page

  Scenario: Profile page works as expected
    When  user clicks on his email in the top right corner
    And user clicks on the My Profile from the dropdown
    Then user is able to see the following options
    |General|
    |Drive|
    |Tasks|
    |Calendar|
    |Conversations|
    And user is able to see his email under the General tab