@login
Feature: AzulCRM login page functionality

  Agile story: As a user I should be able to login with valid credentials to different accounts.
  Accounts are: HR, Helpdesk, Marketing.

  Scenario Outline: For all the scenarios
    Given user is on the login page
    When user logs in as "<user>"
    And user enters "<login>" and "password"
    Then  user should see "<keyword>" in page URL

    Examples: all the credentials
      | user      | login                 | keyword    |
      | HR        | hr23@cydeo.com        | (1) Portal |
      | Marketing | marketing23@cydeo.com | Portal     |
      | Helpdesk  | helpdesk23@cydeo.com  | Portal     |


