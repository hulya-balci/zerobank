@login
Feature: User should be able to login

Background:
  Given Users should be able to login to the application


  Scenario: Enter with valid credentials
    When Users login with valid username and password
    Then Account summary page should be displayed


     @negative
     Scenario Outline: Enter with invalid credentials
      When Users login with not valid "<username>" and "<password>"
      Then Error message "Login and/or password are wrong." display

      Examples:
      |username| password|
      |invalid   | password|
      |username |invalid   |
      |         | password|
      |username|         |
