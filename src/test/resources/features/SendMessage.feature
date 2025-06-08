@SendMessage
Feature: Sending messages functionality

  Agile story: As a user, I should be able to send messages
  by clicking on Message tab under Active Stream.

  Scenario Outline: 1. Send message feature works as expected
    Given user logs in as "<userType>"
    When user clicks on the message tab
    And user doesn't type any text and press send button
    Then user sees the title error message "The message title is not specified"
    When user types any text, but removes All employees from recipients
    Then user sees the recipient error message "Please specify at least one person."
    And user adds recipients back and fills all the mandatory fields
    Then user is able to send a message

    Examples: for all 3 user types
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

    @SecondOutline
   Scenario Outline: 2.  The message delivery should be to 'All employees' by default.
      Given user logs in as "<userType>"
     When user clicks on the message tab
     Then user sees the All employees in the message delivery by default

     Examples: for all 3 user types
       | userType  |
       | hr        |
       | help_desk |
       | marketing |

  @ThirdOutline
  Scenario Outline: 3.  User should be able to cancel sending message at any time before sending.
    Given user logs in as "<userType>"
    When user clicks on the message tab
    And user fills all the mandatory fields
    Then user is able to cancel the message before sending

    Examples: for all 3 user types
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

