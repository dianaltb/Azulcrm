Feature: Drive page functionality

  Agile Story: As a user I want to access the Drive page and see 6 modules:
  "My Drive, All Documents, Company Drive, Sales and Marketing, Top Management’s documents, Drive Cleanup"

@alex
  Scenario Outline:
    Given user logs in as "<userType>"
    When user clicks on "Drive page"
    Then user sees following modules:
      | My Drive                   |
      | All Documents              |
      | Company Drive              |
      | Sales and Marketing        |
      | Top Management's documents |
      | Drive Cleanup              |

    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |
