package com.wordpress.actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.wordpress.elements.ProfileElements;
import com.wordpress.utilities.SetupDrivers;

public class ProfileActions {

	ProfileElements elements;
	
	private String username = "dikeshshrestha";
	
	public  String publicName;

	public ProfileActions() {
		this.elements = new ProfileElements();
		PageFactory.initElements(SetupDrivers.driver, elements);
	}

	public void getWordPressProfilePage() {
		SetupDrivers.driver.get("https://wordpress.com/me");
		SetupDrivers.driver.manage().window().maximize();
		SetupDrivers.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	public String getFirstName() {
		String firstname = elements.firstName.getText();
		return firstname;
	}
	public String getLastName() {
		String lastname = elements.lastName.getText();
		return lastname;
	}
	
	public  String getPublicName() {
		String publicname = elements.displayName.getText();
		return publicname;
	}
	
	public String getAbtme() {
		String abtme = elements.description.getText();
		return abtme;
	}

	public void enterUserName() {
		elements.username.sendKeys(username);
	}

	public void clickContinueBtn() {
		elements.continueloginButtn.click();
	}

	public void enterPassword() {
		elements.password.sendKeys("trialpassword123");
	}

	public boolean verifyprofile() {
		boolean bool = false;

		if (SetupDrivers.driver.getTitle().contains("My Profile")) {
			bool = true;
		}
		return bool;
	}

	public void enterFirstName(String firstName) {
		elements.firstName.clear();
		elements.firstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		elements.lastName.clear();
		elements.lastName.sendKeys(lastName);
	}

	public void enterPublicName(String publicName) {
		elements.displayName.clear();
		elements.displayName.sendKeys(publicName);
		this.publicName = publicName;
	}

	public void enterAboutMe(String description) {
		elements.description.clear();
		elements.description.sendKeys(description);
	}

	public Boolean verifyProfileName(String publicName) {
		Boolean bool = false;
		WebElement pubName = SetupDrivers.driver.findElement(By.xpath("//h2[text()='" + publicName + "']"));
		System.out.println(pubName.getText());
		if (pubName.isDisplayed()) {
			bool = true;
		}
		return bool;
	}

	public void clickYourProfileLink() {
		elements.profileLink.click();
	}

	public Boolean verifyNewProfileWindow() {
		Boolean bool = false;
		String parentWindow = SetupDrivers.driver.getWindowHandle();
		Set<String> windows = SetupDrivers.driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!parentWindow.equals(childWindow)) {
				SetupDrivers.driver.switchTo().window(childWindow);
				System.out.println("Child Window Handler: " + childWindow);
				System.out.println(
						">> Child Window title: " + SetupDrivers.driver.switchTo().window(childWindow).getTitle());
			}
		}
		if(windows.size()>1) {
			bool = true;
		}
		return bool;
	}
	
	public Boolean verifyProfileInfoTab() {
		Boolean bool = false; 
		if(SetupDrivers.driver.getTitle().contains(publicName)) {
			bool = true;
		}
		
		return bool;
		
	}

	public void clickSaveButton() {
		elements.saveButton.click();
	}

	public boolean verfiySaveAction() {
		boolean flag = false;
		if (elements.successNotification.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
	public Boolean verifyUsernamewithPublicName() {
		Boolean bool = false;
		String publicName = elements.displayName.getAttribute("value");
		System.out.println(publicName);
		if(publicName.equals(username)) {
			bool = true;
		}
		
		return bool;
		
	}

	public void clickGavatarLink() {
		elements.gravatarLink.click();
	}
	public Boolean verifyNewGavatarWindow() {
		Boolean bool = false;
		String actualchildUrl = null;
		String expectedchildUrl = null; 
		String parentWindow = SetupDrivers.driver.getWindowHandle();
		
		Set<String> windows = SetupDrivers.driver.getWindowHandles();
		
		for (String childWindow : windows) {
			if (!parentWindow.equals(childWindow)) {
				SetupDrivers.driver.switchTo().window(childWindow);
				actualchildUrl = SetupDrivers.driver.switchTo().window(childWindow).getCurrentUrl();
			      expectedchildUrl = "http://en.gravatar.com/support/profile-hovercards/";
			}
	
			if(actualchildUrl == expectedchildUrl) {
				bool = true;
			}
		
		}
		return bool;

}}