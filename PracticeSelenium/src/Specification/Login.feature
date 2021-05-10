Feature: Login feature

  Scenario Outline: valid login
    Given the user is on stackflow homepage
    When the user clicks on the Login button in the top navigation
    And user enters email as "<email>" and password as "<password>"
    And user clicks Log in
    Then the user is navigated to the correct page

    Examples:
    |email                  |password   |
    |testckclassic@gmail.com|Testing123!|
    |testckclassic@gmail.com|hello      |

