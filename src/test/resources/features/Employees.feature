@employees
Feature: Employees page modules visibility

  Scenario Outline: Employees module displays 8 modules and Company Structure is default
    Given user logs in as "<userType>"
    When the user clicks the Employees module
    Then the user should see the following modules on the page:
      | Company Structure       |
      | Find Employee           |
      | Telephone Directory     |
      | Staff Changes           |
      | Efficiency Report       |
      | Honored Employees       |
      | Birthdays               |
      | New page                |
    And the "Company Structure" module should be selected by default

    Examples: for all 3 user types
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

