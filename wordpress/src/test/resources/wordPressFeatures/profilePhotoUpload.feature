
@PhotoUpload
Feature: Validating profile photo upload feature
  I want to upload my profile picture

  @Smoke
  Scenario: Upload my picture from my device to wordpress
    Given I land on wordpress my user profile page
    When I click the Click to change the photo icon
    And I upload the photo file from my system
    Then I should see the message that says my photo is successfully uploaded
    Then My photo is uploaded to be displayed in my profile
    
  #@Smoke1 @Negetice
  #Scenario: Validating that I see an error message if I try to Upload wrong file type
    #Given I land on wordpress my user profile page
    #When I click the Click to change the photo icon
    #And I upload the photo file from my system
    #Then I should see the esrror message that says the file is not supported

  @Smoke2
  Scenario: Clicking your profile photo is public info link
    Given I land on wordpress my user profile page
    And my profile photo is uploaded
    When I click the i icon next to your profile photo is public text
    Then I should see a message from wordpress and a link to gravator
    And I click the gravator link
	  Then I land on a new gravatar window with my profile

