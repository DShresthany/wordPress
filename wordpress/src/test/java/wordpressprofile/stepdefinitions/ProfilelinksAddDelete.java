package wordpressprofile.stepdefinitions;





import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wordpress.actions.ProfilelinksAction;
import com.wordpress.utilities.SetupDrivers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilelinksAddDelete {
	
	ProfilelinksAction action = new ProfilelinksAction();
	
	@Given("There no Url links present in the profile links")
	public void there_no_Url_links_present_in_the_profile_links() throws InterruptedException {
		action.deletAllLinks();

	}
	
	@When("I click the add buttion")
	public void i_click_the_add_buttion() {
	
		action.clickAddLink();		
	}

	@When("I click add url item")
	public void i_click_add_url_item() {
		action.selectURL();
	}
	
	@Then("URl and description text boxes should appear")
	public void url_and_description_text_boxes_should_appear() {
		Assert.assertEquals(true, action.verifyAddUrlbox());
		Assert.assertEquals(true, action.verifyAddDescriptionbox());
	}

	@Then("I enter a valid url {string} and description {string}")
	public void i_enter_a_valid_url_and_description(String url, String description) {
		action.enterUrl(url);
		action.enterDescription(description);
	}


	@Then("I click Add Site button")
	public void i_click_Add_Site_button() {
		action.clickAddSiteButton();
	}

	@Then("The link of the url should be added in the profile links")
	public void the_link_of_the_url_should_be_added_in_the_profile_links() {
		Assert.assertEquals(true, action.verifyUrl());
		Assert.assertEquals(true, action.verifyDescription());
	}

	@Then("I click the x sign")
	public void i_click_the_x_sign() {
	  
	}

	@Then("I can delete the url link")
	public void i_can_delete_the_url_link() {
	  
	}
	
	@Then("I click the x sign next to url {string}")
	public void i_click_the_x_sign_next_to_url(String url) {
	   
	}
	
	@Then("I fail to enter a valid url {string} or description {string}")
	public void i_fail_to_enter_a_valid_url_or_description(String url, String description) {
	  action.enterUrl(url);
	  action.enterDescription(description);
	}

	@Then("The link of the add site button is not clickable")
	public void the_link_of_the_add_site_button_is_not_clickable() {
    Assert.assertEquals(true, action.verifyAddDescriptionbox());
}

	@Then("The I should see an error notification")
	public void the_I_should_see_an_error_notification() {
	 Assert.assertEquals(true, action.verifyErrorMessage());
	}
	
	@Then("I click the cancel button")
	public void i_click_the_cancel_button() {
		action.clickCancelButton();
	}

	@Then("I should not see the url and description input fields")
	public void i_should_not_see_the_url_and_description_input_fields() {
	//	Assert.assertEquals(true, action.verifyAddButtonDisabled());
		Assert.assertEquals(true, action.verifyCancel());
	//	Assert.assertEquals(false, action.verifyAddDescriptionbox());
	}

	@Then("I click the {string} link")
	public void i_click_the_link(String url) {
	  action.clickUrlLink(url);
	}

	@Then("I should land on new window of the {string} link")
	public void i_should_land_on_new_window_of_the_link(String url) {
	   Assert.assertEquals(true, action.verfifyUrlOpens(url));
	}
	
	@When("I click the Add WordPress Site item")
	public void i_click_the_Add_WordPress_Site_item() {
		action.clickAddWordPressSite();
	}

	@Then("I click the create site button")
	public void i_click_the_create_site_button() {
	  action.clickCreateSiteButton();
	}
	@Then("I should land on a new window")
	public void i_should_land_on_a_new_window() {
	 Assert.assertEquals(true, action.verfifyCreateSiteWindow());
	}
	
	@When("I click the jetpack link")
	public void i_click_the_jetpack_link() {
	  action.clickJetpackLink();
	}

	@Then("I should land on a new jetpack window")
	public void i_should_land_on_a_new_jetpack_window() {
		 Assert.assertEquals(true, action.verifyJetpackPage());
	}


}
