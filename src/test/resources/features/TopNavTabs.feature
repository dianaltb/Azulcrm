@TopNavTabs
Feature: Activity Stream page top feature tabs visibility

  Agile Story:As a user, I should be able to see all the options on the Activity stream page.

  Scenario Outline: All users can see top-level Activity Stream options

    Given user logs in as "<userType>"
    When the user navigates to the Activity Stream page
    Then the user should see the following options on the page:
      | MESSAGE |
      | TASK    |
      | EVENT   |
      | POLL    |
      | MORE    |

    Examples: for all 3 user types
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

  Scenario Outline: All users can see MORE tab options under Activity Stream
    Given user logs in as "<userType>"
    When the user navigates to the Activity Stream page
    And the user clicks the "MORE" tab
    Then the user should see the following options under the MORE tab:
      | File             |
      | Appreciation     |
      | Announcement     |
      | Workflow         |

    Examples: for all 3 user types
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

