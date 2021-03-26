package wordpressprofile.stepdefinitions;




import java.awt.AWTException;

import org.junit.Assert;

import com.wordpress.actions.PhotoUploadActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhotoUploadStepDefs {
	
	PhotoUploadActions photoActions = new PhotoUploadActions();
	
	@When("I click the Click to change the photo icon")
	public void i_click_the_Click_to_change_the_photo_icon(){
		photoActions.clickUploadBtn();
	}

	@When("I upload the photo file from my system")
	public void i_upload_the_photo_file_from_my_system() throws AWTException {
	 photoActions.uploadPhoto();
	}

	@Then("I should see the message that says my photo is successfully uploaded")
	public void i_should_see_the_message_that_says_my_photo_is_successfully_uploaded() throws InterruptedException {
	   Assert.assertEquals(true, photoActions.verifysuccessfulUpload());
	}

	@Then("My photo is uploaded to be displayed in my profile")
	public void my_photo_is_uploaded_to_be_displayed_in_my_profile() {

	}

	@Given("my profile photo is uploaded")
	public void my_profile_photo_is_uploaded() {

	}

	@When("I click the i icon next to your profile photo is public text")
	public void i_click_the_i_icon_next_to_your_profile_photo_is_public_text() {
		photoActions.clickIicon();
	}

	@Then("I should see a message from wordpress and a link to gravator")
	public void i_should_see_a_message_from_wordpress_and_a_link_to_gravator() {
		Assert.assertEquals(true, photoActions.verifyMessage());
	}

	@Then("I click the gravator link")
	public  void i_click_the_gravator_link() {
		photoActions.clickGravatarLink();
	}
	
	@Then("I land on a new gravatar window with my profile")
	public void i_land_on_a_new_gravatar_window_with_my_profile() {
	   Assert.assertEquals(true, photoActions.verifyGravatarTab());
	}

}
