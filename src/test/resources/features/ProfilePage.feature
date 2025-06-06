@Profile
Feature: Profile page functionality.

  Agile story: As a user, I want to access my profile page.

  Scenario Outline: Profile page works as expected for all user types
    Given user logs in as "<userType>"
    When  user clicks on his email in the top right corner
    And user clicks on the My Profile from the dropdown
    Then user is able to see the following options
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |
    And user is able to see his "<email>" under the General tab

    Examples: For all 3 types of user:
      | userType  | email|
      | hr        | hr23@cydeo.com|
      | help_desk | helpdesk23@cydeo.com|
      | marketing | marketing23@cydeo.com|