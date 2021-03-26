@addUrl
Feature: Wordpress profile add feature
  I want to use add feature in th e Profile Links

  @smoke
  Scenario Outline: Validating that user can click the add button and add url
    Given I land on wordpress my user profile page
    And There no Url links present in the profile links
    When I click the add buttion
    And I click add url item
    Then URl and description text boxes should appear
    And I enter a valid url "<Url>" and description "<Description>"
    And I click Add Site button
    Then The link of the url should be added in the profile links

    Examples:
      | Url                          | Description             |
      | https://www.espn.com/soccer/ | It is a Soccer Website  |
      | https://www.amazon.com/      | It is an Amazon Website |

  @smoke
  Scenario Outline: Validating that user can land on a new browser window by clicking the url link
    Given I land on wordpress my user profile page
    And There no Url links present in the profile links
    When I click the add buttion
    And I click add url item
    Then URl and description text boxes should appear
    And I enter a valid url "<Url>" and description "<Description>"
    And I click Add Site button
    Then The link of the url should be added in the profile links
    And I click the "<Url>" link
    Then I should land on new window of the "<Url>" link

    Examples:
      | Url                          | Description             |
      | https://www.espn.com/soccer/ | It is a Soccer Website  |
      | https://www.amazon.com/      | It is an Amazon Website |


  @smoke1
  Scenario Outline: Validating that user can delete url link from the Profile links section
    Given I land on wordpress my user profile page
    And There no Url links present in the profile links
    When I click the add buttion
    And I click add url item
    Then URl and description text boxes should appear
    And I enter a valid url "<Url>" and description "<Description>"
    And I click Add Site button
    Then The link of the url should be added in the profile links
    And I click the x sign next to url "<Url>"
    Then I can delete the url link

    Examples:
      | Url                          | Description             |
      | https://www.espn.com/soccer/ | It is a Soccer Website  |
      | https://www.amazon.com/      | It is an Amazon Website |


  @smoke2 @negetive
  Scenario Outline: Validating that user cannot add url link without description
    Given I land on wordpress my user profile page
    And There no Url links present in the profile links
    When I click the add buttion
    And I click add url item
    Then URl and description text boxes should appear
    And I fail to enter a valid url "<Url>" or description "<Description>"
    Then The link of the add site button is not clickable


    Examples:
      | Url                          | Description            |
      | https://www.espn.com/soccer/ |                        |
      |                              | It is a amazon Website |


  @smoke3 @negetive
  Scenario Outline: Validating that user cannot add existing url
    Given I land on wordpress my user profile page
    And There no Url links present in the profile links
    When I click the add buttion
    And I click add url item
    Then URl and description text boxes should appear
    And I enter a valid url "<Url>" and description "<Description>"
    And I click Add Site button
    And I click the add buttion
    And I click add url item
    Then URl and description text boxes should appear
    And I enter a valid url "<Url>" and description "<Description>"
    And I click Add Site button
    Then The I should see an error notification


    Examples:
      | Url                          | Description            |
      | https://www.espn.com/soccer/ | It is a soccer Website |


  @smoke4 @negetive
  Scenario Outline: Validating that user cannot add invalid url input
    Given I land on wordpress my user profile page
    And There no Url links present in the profile links
    When I click the add buttion
    And I click add url item
    Then URl and description text boxes should appear
    And I enter a valid url "<Url>" and description "<Description>"
    Then The link of the add site button is not clickable


    Examples:
      | Url               | Description      |
      | invalid data      | invalid data     |
      | asdjkjdsa/;/asdnk | jkasjdkasdas2331 |
    
  #@smoke4
  #Scenario Outline: Validating that user can click the cancel button to abort the process
    #Given I land on wordpress my user profile page
    #When I click the add buttion
    #And I click add url item
    #Then URl and description text boxes should appear
    #And I enter a valid url "<Url>" and description "<Description>"
    #And I click the cancel button
    #Then I should not see the url and description input fields
    #
    #Examples:
    #|             Url                   |         Description          |
    #|  https://www.espn.com/soccer/     |     It is a Soccer Website   |
    #|    https://www.amazon.com/        |     It is an Amazon Website  |

  @addWordPressSite @smoke
  Scenario: Validating that user can click the add button and add WordPress site
    Given I land on wordpress my user profile page
    When I click the add buttion
    And I click the Add WordPress Site item
    And I click the create site button
    Then I should land on a new window

  @addWordPressSite @smoke1
  Scenario: Validating that user can click the jetpack link and land on jetpack homepage
    Given I land on wordpress my user profile page
    When I click the add buttion
    And I click the Add WordPress Site item
    And I click the jetpack link
    Then I should land on a new jetpack window
		
		

    
    


