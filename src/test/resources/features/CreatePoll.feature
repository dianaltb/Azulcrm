@poll
Feature:AzulCRM Create Poll functionality
  Agile Story: User should be able to create a poll
  by clicking on Poll tab under Active Stream

  Scenario Outline: The delivery option 'All employees' by default.
    When user logs in as "<userType>"
    Given user clicks on the Poll tab
    Then user sees the All employees in the message delivery by default
    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

  Scenario Outline: User creates a poll with valid inputs
    When user logs in as "<userType>"
    Given user clicks on the Poll tab
    When user enters text as the message title
    And user types question text in Question field
    And user adds answer text in Answer field
    And user clicks the send button
    Then user should be able to create poll
    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

  Scenario Outline: Validation "Allow multiple" choice checkbox
    When user logs in as "<userType>"
    Given user clicks on the Poll tab
    Then user clicks on “Allow multiple choice” checkbox
    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

  @PollErrors
  Scenario Outline: Mandatory fields verification under Poll tab
  Mandatory fields: Message title, recipient, 1 question, 1 answer.
    When user logs in as "<userType>"
    Given user clicks on the Poll tab
    And user clicks the send button
    Then user sees the error message "The message title is not specified"
    When user types any text, but removes All employees from recipients
    And user clicks the send button
    Then user sees the error message "Please specify at least one person."
    When user adds answer text in Answer field
    And user clicks the send button
    Then user sees the error message "The question text is not specified."
    When user removes answer from answer field
    And user types question text in Question field
    And user clicks the send button
    Then user sees the error message The question has no answers.

    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |
