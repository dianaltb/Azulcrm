@uploading
Feature: File and pic uploading

  Agile story:
  As a user, I should be able to upload files and pictures to appreciation in
  Supported file formats .pdf, .txt, .jpeg, .png, .docx



  Scenario Outline:  Checking the attaching of the file
    Given user logs in as "<userType>"
    When user clicks on "More" dropdown
    And user clicks on "Appreciation" button
    And user clicks on "upload file" icon
    When user uploads a file "muhtar.png"
    Then user sees the file is attached

    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

  Scenario Outline: Checking the inserting of the file in text
    Given user logs in as "<userType>"
    When user clicks on "More" dropdown
    And user clicks on "Appreciation" button
    And user clicks on "upload file" icon
    When user uploads a file "muhtar.png"
    Then user sees the file is attached
    When user clicks "insert in text" button
    Then user should see "In text" displayed on the button

    Examples:
      | userType  |
      | hr        |
      | help_desk |
      | marketing |

  Scenario Outline: Checking the removing the file before sending the text
    Given user logs in as "<userType>"
    When user clicks on "More" dropdown
    And user clicks on "Appreciation" button
    And user clicks on "upload file" icon
    When user uploads a file "muhtar.png"
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



