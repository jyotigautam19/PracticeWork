Feature: BJSS home page

Scenario: The menu is expandable on BJSS home page
  Given the user is on the BJSS home page
  When they click the menu
  Then the menu is expanded

  Scenario: More information about BJSS Whitepaper
    Given the user is on the BJSS home page
    When they click for more information about the BJSS whitepaper
    Then they are shown more information about the BJSS whitepaper

