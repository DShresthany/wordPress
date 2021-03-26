@profilepage
Feature: WordPress profile page update test

  @smoke
  Scenario Outline: Create a user profile
    Given I land on wordpress my user profile page
    And I enter my first name "<firstname>", lastname "<lastname>", public display name "<public display name>" and about me description "<description>"
    When I click the save profile details button
    Then I can see Settings saved successfully notification
    Then I should see my public name "<public display name>" displayed in the profile
    And I click your profile link
    Then I land on a new window
    Then I can see my profile Information

    Examples: 
      | firstname | lastname | public display name | description                |
      | Dikesh    | Shrestha | Dikesh              | My name is Dikesh Shrestha |
      | Jacky     | Shrestha | Jacky123            | My name is Jacky Shrestha  |
      |	Mike O'Leary| Jôse   | Mikey               | Long description -Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce vel elit eu est tincidunt luctus pretium et massa. Maecenas vitae nisl dictum, consectetur justo in, fringilla massa. Interdum et malesuada fames ac ante ipsum primis in faucibus. Cras ultricies tortor id fringilla varius. Nullam facilisis eleifend felis, ut congue est. Suspendisse justo orci, gravida at lacus cursus, mattis imperdiet diam. Nullam ornare dolor et leo ullamcorper rhoncus. Proin finibus, metus in laoreet sodales, ante velit ultricies lacus, et sodales mi libero eget odio. Phasellus at faucibus ligula, ultrices tempus est. Proin in consequat elit. In quam eros, pharetra vitae massa. |
      |	LongName-Lorem ipsum dolor sit amet,|  Fusce vel elit eu est tincidunt luctus  |  Maecenas vitae nisl dictum, consectetur justo in, fringilla massa   | Lorem ipsum dolor sit amet  |
      #More scenarios like empty firstname and lastname
      
      
  @smoke
  Scenario Outline: Validating that if public display name is left empty it reverts to username
    Given I land on wordpress my user profile page
    And I enter my first name "<firstname>", lastname "<lastname>", public display name "<public display name>" and about me description "<description>"
    When I click the save profile details button
    Then I can see Settings saved successfully notification
    Then I should see my public name username as my public display name

    Examples: 
      | firstname | lastname | public display name | description                |
      | Dikesh    | Shrestha |                     | My name is Dikesh Shrestha |
      | Jacky     | Shrestha |                     | My name is Jacky Shrestha  |

  @regression
  Scenario Outline: Validating the user information are persisted after refresh
    Given I land on wordpress my user profile page
    And I enter my first name "<firstname>", lastname "<lastname>", public display name "<public display name>" and about me description "<description>"
    And I refresh the page
    Then I should see the my previous profile information

    Examples: 
      | firstname | lastname | public display name | description                |
      | Shrestha  | Dikesh   | Shrestha            | My name is Dikesh Shrestha |

  @regression
  Scenario Outline: Validating the user information are persisted after navigating back and forword in the browser
    Given I land on wordpress my user profile page
    And I enter my first name "<firstname>", lastname "<lastname>", public display name "<public display name>" and about me description "<description>"
    And I refresh the page
    Then I should see the my previous profile information

    Examples: 
      | firstname | lastname | public display name | description           |
      | Mali      | jacky    | Shrestha            | My name is Jacky Mali |

  @Smoke
  Scenario: Validating the Gravatar Hovercards link
    Given I land on wordpress my user profile page
    When I click on Gravatar Hovercards link
    Then I should land on a new gravatar window
