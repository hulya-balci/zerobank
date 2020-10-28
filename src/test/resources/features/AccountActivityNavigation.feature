

Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in


@wip
  Scenario: Savings account redirect
    When the user clicks on Savings link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Savings" selected


