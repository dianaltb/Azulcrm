@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user is on the login page

  #@hr
  Scenario: Verify login with hr credentials
    Given the user logged in as "<hr>"
    Given the user logged in with username as "hr_username" and password as "UserUser"
#@helpDesk
  Scenario: Verify login with help_desk credentials
    Given the user logged in as "<help_desk>"
    Given the user logged in with username as "help_desk_username" and password as "UserUser"

#@marketing

Scenario: Verify login with marketing credentials
  Given the user logged in as "<marketing>"
  Given the user logged in with username as "marketing_username" and password as "UserUser"

# you can use one of the given step here

