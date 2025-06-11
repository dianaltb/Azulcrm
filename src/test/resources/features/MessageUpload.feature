@MessageUpload
Feature: Uploading pictures and files as messages functionality

  User Story:As a user, I should be able to upload files and pictures as messages
  Supported file formats .pdf, .txt, .jpeg, .png, .docx

  Scenario Outline:  Verify the picture is successfully attached
    Given user logs in as "<userType>"
    When user clicks on the message tab
    And user clicks on upload files icon
    When user uploads a file "skinnykelly.jpg"
    Then user sees the file is attached
    When user clicks "insert in text" button
    Then user should see "In text" displayed on the button
    When user clicks on x to remove the file
    Then user confirms file is removed before sending text

    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

  Scenario Outline:  Verify the file is successfully attached
    Given user logs in as "<userType>"
    When user clicks on the message tab
    And user clicks on upload files icon
    When user uploads a file "sample.txt"
    Then user sees the file is attached
    When user clicks "insert in text" button
    Then user should see "In text" displayed on the button
    When user clicks on x to remove the file
    Then user confirms file is removed before sending text

    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

