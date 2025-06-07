@login
Feature: AzulCRM login page functionality

  Agile story: As a user I should be able to login with valid credentials to different accounts.
  Accounts are: HR, Helpdesk, Marketing.

  Scenario Outline: Verify that <userType> user can log in with valid credentials and land on the home page after successful login
    When user logs in as "<userType>"
    Then user should be able to see "<title>" as page title

    Examples:
      | userType  | title      |
      | hr        | (1) Portal |
      | help_desk | Portal     |
      | marketing | Portal     |


