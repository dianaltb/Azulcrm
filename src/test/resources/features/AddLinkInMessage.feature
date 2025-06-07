@addLink
Feature: Adding link in message functionality
  Agile story: As a user, I can add link in message and after sending the message
  I can see the link text as a clickable link.

  @validLink
  Scenario Outline: Add a valid link verification
    Given user logs in as "<userType>"
    When user clicks on activity stream button
    And user clicks on massage button
    And user clicks on link button
    When user enters "<linkText>" in text box
    And user enters "<linkUrl>" in URL box
    And user clicks on Save button
    And user clicks on send button
    Then user sees the "<linkText>" as a clickable link.
    Examples:
      | userType  | linkText           | linkUrl                |
      | hr        | google search page | https://www.google.com |
      | help_desk | google search page | https://www.google.com |
      | marketing | google search page | https://www.google.com |




