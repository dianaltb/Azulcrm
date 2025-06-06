@employees
Feature: Employees page modules visibility

  Scenario: Employees module displays 8 modules and Company Structure is default
    Given user logs in as "marketing"
    When the user clicks the "Employees" module
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

