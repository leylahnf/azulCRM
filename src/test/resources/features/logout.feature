Feature: Logout Functionality
  US: As a user, I should be able to log out



#ac1

 Scenario Outline: User can log out and ends up on the login page
    Given User is on the login page and enters valid credentials "<email>" and "<password>"
   When user clicks on user account menu
   And  user clicks on logout link
   Then user should go back to login page, verify title "Authorization"


   Examples: As a hr user
     | email                   | password |
     | hr10@cybertekschool.com | UserUser |
     | hr88@cybertekschool.com | UserUser |

  Examples: As a helpdesk user
    | email                         | password |
    | helpdesk50@cybertekschool.com | UserUser |
    | helpdesk11@cybertekschool.com | UserUser |

    Examples: As a marketing user
      | email                          | password |
      | marketing97@cybertekschool.com | UserUser |
      | marketing98@cybertekschool.com | UserUser |
# ac2

  Scenario Outline: User can not go to the home page again by clicking the step back button after successfully logging out
    Given User is on the login page and enters valid credentials "<email>" and "<password>"
    When user clicks on user account menu
    And  user clicks on logout link
    And user should go back to login page, verify title "Authorization"
    And user try to go back home page by clicking the back button
    Then user still is on the login page


    Examples: As a hr user
      | email                   | password |
      | hr10@cybertekschool.com | UserUser |
      | hr88@cybertekschool.com | UserUser |

    Examples: As a helpdesk user
      | email                         | password |
      | helpdesk50@cybertekschool.com | UserUser |
      | helpdesk11@cybertekschool.com | UserUser |

    Examples: As a marketing user
      | email                          | password |
      | marketing97@cybertekschool.com | UserUser |
      | marketing98@cybertekschool.com | UserUser |

  # ac3

  Scenario Outline:  The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    Given User is on the login page and enters valid credentials "<email>" and "<password>"

    When user closes the browser
   # And user is logged out
    And user open new browser and try to navigate to home page
    Then user still is on the login page
  @a
    Examples: As a hr user
      | email                   | password |
      | hr10@cybertekschool.com | UserUser |
      | hr88@cybertekschool.com | UserUser |

    Examples: As a helpdesk user
      | email                         | password |
      | helpdesk50@cybertekschool.com | UserUser |
      | helpdesk11@cybertekschool.com | UserUser |

    Examples: As a marketing user
      | email                          | password |
      | marketing97@cybertekschool.com | UserUser |
      | marketing98@cybertekschool.com | UserUser |





