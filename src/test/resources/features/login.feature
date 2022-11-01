
Feature: Login Functionality
  US: As a user, I should be able to log in

  Background: User should be able to login page
    Given user goes to the login page

    #1.ac


  Scenario Outline: All users can log in with valid credentials

    When  user enters valid email "<email>"
    And user enters valid password "<password>"
    And user clicks the Log In button
    Then user should be able to login successfully and verify title contains "Portal"

    @AZUL-1435 @wip
    Examples: Log in as a HR user
      | email                   | password |
      | hr1@cybertekschool.com  | UserUser |
      | hr10@cybertekschool.com | UserUser |
      | hr18@cybertekschool.com | UserUser |
      | hr41@cybertekschool.com | UserUser |
      | hr56@cybertekschool.com | UserUser |

    @AZUL-1436 @wip
    Examples: Log in as a Marketting user
      | email                          | password |
      | marketing97@cybertekschool.com | UserUser |
      | marketing85@cybertekschool.com | UserUser |
      | marketing99@cybertekschool.com | UserUser |
      | marketing86@cybertekschool.com | UserUser |
      | marketing93@cybertekschool.com  | UserUser |

    @AZUL-1437 @wip
    Examples: Log in as a Helpdesk user
      | email                         | password |
      | helpdesk1@cybertekschool.com  | UserUser |
      | helpdesk2@cybertekschool.com  | UserUser |
      | helpdesk5@cybertekschool.com  | UserUser |
      | helpdesk25@cybertekschool.com | UserUser |
      | helpdesk35@cybertekschool.com | UserUser |


    #2.ac
  @AZUL-1438 @wip
  Scenario Outline: User can not login with invalid credentials
    When user logins invalid credentials "<email>" and "<password>"
    Then user should see warning message "Incorrect login or password"

    Examples: Invalid user credentials
      | email                        | password |
      | hr@cybertekschool.com        | UserUser |
      | helpdesk1@cybertekschool.com | User     |
      | abc@cybertekschool.com       | User     |
      |                              | UserUser |
      | hr1@cybertekschool.com       |          |
      |                              |          |

    # 3.ac


     Scenario Outline: User see "Please fill out this field" message  if the password or username is empty
       When user enters valid email "<email>"
       And user does not enter any password
       And user clicks the Log In button
       Then user should be able to see "Please fill out this field" message

      @AZUL-1439 @wip
       Examples: Empty password inbox
      | email                          | password |
      | hr1@cybertekschool.com         |          |
      | helpdesk1@cybertekschool.com   |          |
      | marketing97@cybertekschool.com |          |

    @AZUL-1440 @wip
      Scenario: Verification for not existing warning message
        When user does not enter any email
        And user enters valid password "UserUser"
        And user clicks the Log In button
        Then user should be able to see "Please fill out this field" message

     # 4. ac
    @AZUL-1441 @wip
      Scenario: User see "Get Password" text after clicking the "Forgot your password?" link
        When user clicks the "Forgot your password?" link
        Then user should be able to land on "Get Password" page after clicking the link
  # ac5
   @AZUL-1442 @wip
      Scenario: User can see "Remember Me" link exists and is clickable on the login page
        When user enters valid email "hr1@cybertekschool.com"
        And user enters valid password "UserUser"
        And user see the "Remember Me" link exists on the login page
        Then user verify link should be clickable

    #ac6
   @AZUL-1443 @wip
      Scenario: User should see the password in bullet signs by default
        When user enters valid email "hr1@cybertekschool.com"
        And user enters valid password "UserUser"
        Then password should be in bullet signs by default


  #ac7
  @AZUL-1444 @wip
  Scenario: 'Enter' key of the keyboard should work correctly on the login page
    When user enters valid email "hr1@cybertekschool.com"
    And user enters valid password "UserUser" and press Enter key of the keyboard for log in
    Then user should be able to login successfully and verify title contains "Portal"


  # ac 8

  Scenario Outline: All users can see their own usernames in the profile menu, after successful login
    When  user enters valid email "<email>"
    And user enters valid password "<password>"
    And user clicks the Log In button
    Then users should be able to see their own "<accountUsername>" in the profile menu

    @AZUL-1445 @wip
    Examples: Log in as a HR user
      | email                   | password | accountUsername         |
      | hr1@cybertekschool.com  | UserUser | hr1@cybertekschool.com  |
      | hr10@cybertekschool.com | UserUser | hr10@cybertekschool.com |

    @AZUL-1446 @wip
    Examples: Log in as a Marketting user
      | email                          | password | accountUsername                |
      | marketing97@cybertekschool.com | UserUser | marketing97@cybertekschool.com |
      | marketing85@cybertekschool.com | UserUser | marketing85@cybertekschool.com |

    @AZUL-1447 @wip
    Examples: Log in as a Helpdesk user
      | email                        | password | accountUsername              |
      | helpdesk1@cybertekschool.com | UserUser | helpdesk1@cybertekschool.com |
      | helpdesk2@cybertekschool.com | UserUser | helpdesk2@cybertekschool.com |














