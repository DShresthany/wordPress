package com.wordpress.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileElements {


	@FindBy(id = "usernameOrEmail")
	public WebElement username;
	
	@FindBy(css = ".button.form-button.is-primary")
	public WebElement continueloginButtn;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(css = ".button.form-button.is-primary")
	public WebElement loginButtn;
	
	@FindBy(id = "first_name")
	public WebElement firstName;
	
	@FindBy(id = "last_name")
	public WebElement lastName;
	
	@FindBy(css = "input[id='display_name']")
	public WebElement displayName;
	
	@FindBy(id = "description")
	public WebElement description;
	
	@FindBy(css = ".button.form-button.is-primary")
	public WebElement saveButton;
	
	@FindBy(xpath = "//*[contains(text(), 'Settings saved successfully!')]")
	public WebElement successNotification;
	
	@FindBy(linkText = "your profile")
	public WebElement profileLink;
	
	@FindBy(linkText = "Gravatar Hovercards")
	public WebElement gravatarLink;
	
}
