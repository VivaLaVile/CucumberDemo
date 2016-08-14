@demo
Feature: User Login
  As a shopper
  I want to be able to sign in to my account
  So that I can make purchases

Scenario: User logs in using correct credentials
  Given I open automationpractice website
  When I attempt to log in using correct credentials
  Then I should log in successfully

Scenario Outline: User attempts to log in using email address only, gets an error
  Given I open automationpractice website
    And I have an email address of <email>
    And I have a password of <password>
  When I attempt to log in using my email address only
  Then I should receive an error
Examples:
| email            | password    |
| cucumber@xyz.com | cucumber123 |

Scenario Outline: User attempts to log in using email address only
  Given I open automationpractice website
    And I have an email address of <email>
    And I have a password of <password>
  When I attempt to log in using my password only
  Then I should receive an error
Examples:
| email            | password    |
| cucumber@xyz.com | cucumber123 |
