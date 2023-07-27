Feature: All tests related to students

  Background:
    Given user is on login page
    When user enters correct email
    And user enters correct password
    And user clicks on login button
    Then user navigates to students tab
@student
  Scenario Outline: Verify admin can create and delete a student
    Then user clicks on add student button
    Then user adds student info with "<first_name>","<last_name>","<phone_number>","<email>","<group>","<study_format>",
    And user clicks on add student button
    Then verify student with "<first_name>","<last_name>","<phone_number>","<email>","<group>","<study_format>" was created
    Then user deletes student with "<email>"
    Then  verify student with "<first_name>","<last_name>","<phone_number>","<email>","<group>","<study_format>" was deleted
    Examples:
      | first_name | last_name | phone_number | email               | group | study_format |
      | dsadsa     | dssadsa   | 321456789    | dsadas@gmail.com    |       | ONLINE       |
      | dsadsa     | dssadsa   | 321456789    | dsaddsas@gmail.com  |       | ONLINE       |
      | dsadsa     | dssadsa   | 321456789    | dsaddsaas@gmail.com |       | ONLINE       |









