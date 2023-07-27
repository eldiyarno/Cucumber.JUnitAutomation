@login
Feature: Test file covers all login test scenarios
  @login
  Scenario: User with right credentials must be able to login
    Given user is on login page
    When user enters email "sakydin.tashmurzaev.kk@gmail.com"
    And user enters password "CodeWise2023!"
    Then user clicks on login button
    Then user must be logged in

  @login2
  Scenario: User with right credentials must be able to login
    Given user is on login page
    When user enters correct email
    And user enters correct password
    Then user clicks on login button
    Then user must be logged in
