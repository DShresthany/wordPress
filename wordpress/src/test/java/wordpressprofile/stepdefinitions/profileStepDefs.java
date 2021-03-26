package wordpressprofile.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.wordpress.actions.ProfileActions;
import com.wordpress.utilities.SetupDrivers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class profileStepDefs {
	
	ProfileActions actions = new ProfileActions();
	
@Given("I land on wordpress my user profile page")
public void i_land_on_wordpress_my_user_profile_page() {
	actions.getWordPressProfilePage();
	actions.enterUserName();
	actions.clickContinueBtn();
	actions.enterPassword();
	actions.clickContinueBtn();
	WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 10);
	wait.until(ExpectedConditions.titleContains("My Profile"));
	Assert.assertEquals(true, actions.verifyProfile());

}

@Given("I enter my first name {string}, lastname {string}, public display name {string} and about me description {string}")
public void i_enter_my_first_name_lastname_public_display_name_and_about_me_description(String firstName, String lastName, String publicName, String description) {
//	WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 5);
//	wait.until(ExpectedConditions.elementToBeClickable(element))
	actions.enterFirstName(firstName);
	actions.enterLastName(lastName);
	actions.enterPublicName(publicName);
	actions.enterAboutMe(description);
	
}

@When("I click the save profile details button")
public void i_click_the_save_profile_details_button() {
	actions.clickSaveButton();
}

@Then("I can see Settings saved successfully notification")
public void i_can_see_Settings_saved_successfully_notification() {
	Assert.assertEquals(true, actions.verfiySaveAction());
}

@Then("I should see my public name {string} displayed in the profile")
public void i_should_see_my_public_name_displayed_in_the_profile(String publicName) {
	Assert.assertEquals(true, actions.verifyProfileName(publicName));
}



@Then("I click your profile link")
public void i_click_your_profile_link() {
   actions.clickYourProfileLink();
}

@Then("I land on a new window")
public void i_land_on_a_new_window() {
	Assert.assertEquals(true, actions.verifyNewProfileWindow());
}

@Then("I can see my profile Information")
public void i_can_see_my_profile_Information() {
	Assert.assertEquals(true, actions.verifyProfileInfoTab());

}

@Given("I refresh the page")
public void i_refresh_the_page() {
	SetupDrivers.driver.navigate().refresh();
}

@Then("I should see the my previous profile information")
public void i_should_see_the_my_previous_profile_information() {

}

@When("I click on Gravatar Hovercards link")
public void i_click_on_Gravatar_Hovercards_link() {
  actions.clickGavatarLink();
}

@Then("I should land on a new gravatar window")
public void i_should_land_on_a_new_gravatar_window() {
  Assert.assertEquals(true, actions.verifyNewGavatarWindow());
}

@Then("I should see my public name username as my public display name")
public void i_should_see_my_public_name_username_as_my_public_display_name() {
	SetupDrivers.driver.navigate().refresh();
	Assert.assertEquals(true, actions.verifyUsernamewithPublicName());

}
}
