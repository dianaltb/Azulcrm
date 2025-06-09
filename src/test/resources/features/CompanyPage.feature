@company
Feature: Company Page Modules visibility

  Agile story: As a user, I should be able to access to the Company Page. So, I can verify all the modules are visible.

  Scenario Outline: Verify visibility of each module on the Company page
    Given user logs in as "<userType>"
    When the user clicks the Company page
    Then the following modules should be visible on the page:

      |Official Information |
      |Our Life |
      |About Company |
      |Photo Company |
      |Video |
      |Career |
      |Business News(RSS) |
      |More |

    Examples: for all 3 user types
      | userType  |
      | hr        |
      | help_desk |
      | marketing |


