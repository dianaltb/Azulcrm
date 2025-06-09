@appreciation
Feature: Appreciation sending functionality

  Agile story: As a user, I should be able to send appreciation by clicking on Appreciation tab under Active Stream
  Account: HR

  Scenario Outline: Appreciation messages sending verification
    Given user logs in as "<userType>"
    And user navigates to appreciation
    And user types in an "appreciation" message
    And user sends the appreciation message
    Then verifies if message is displayed


    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |