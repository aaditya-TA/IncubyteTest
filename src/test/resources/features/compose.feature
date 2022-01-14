Feature: Compose functionality_TC_01
  Verify  "Compose functionality" for Gmail.


  Scenario Outline: Test compose functionality of Gmail
    Given Initialize the browser with chrome
    And User navigate to "https://www.gmail.com"
    And User enters <email> and <password>
    And User is logged into the system
    When User click on compose button
    Then The new message section should be available where the required fields are present
    When User enters <To_Email> In recipients section
    And enters <subject> in Subject section
    And enters <body> in Body section and clicks on the send button
    Then Message is sent
    And User closes the browser


    Examples:
      |email                 |password     |To_Email              |subject                         |body     |
      |jsjswsuhsjs@gmail.com |Password@123 |jsbjabbjhas@gmail.com |Automation QA test for Incubyte |Incubyte |
