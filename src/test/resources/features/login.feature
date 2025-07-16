Feature: SauceDemo Login Functionality

Scenario Outline: Login to SauceDemo with different users and verify result
    Given User is on SauceDemo login page
    When User enters username "<username>" and password "<password>"
    And User clicks on Login button
    Then User should be "<expectedResult>"

Examples:
    | username                | password     | expectedResult |
    | standard_user            | secret_sauce | success        |
    | problem_user             | secret_sauce | failure        |
    | performance_glitch_user  | secret_sauce | success        |
    | visual_user              | secret_sauce | success        |
