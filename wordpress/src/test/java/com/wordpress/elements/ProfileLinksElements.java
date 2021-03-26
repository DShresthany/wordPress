package com.wordpress.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileLinksElements {

	@FindBy(css = "button[type='button'][class='button is-compact']")
	public WebElement addButton;
	
	@FindBy(id = "gridicons-help")
	public WebElement helpButton;
	
	@FindBy(id = "search-component-3")
	public WebElement searchBar;
	
	@FindBy(css = ".button.profile-links-add-other__add.form-button.is-primary")
	public WebElement addSiteLink;
	
	@FindBy(xpath = "//button[text()='Add URL']")
	public WebElement addURLlink;
	
	@FindBy(xpath = "//button[contains(text(), 'Add WordPress Site')]")
	public WebElement addSite;
	
	@FindBy(css = "input[placeholder= 'Enter a URL']")
	public WebElement enterUrlBox;
	
	@FindBy(css = "input[placeholder= 'Enter a description']")
	public WebElement enterDescriptionBox;
	
	@FindBy(css = "button[class='button profile-links-add-other__add form-button is-primary']")
	public WebElement addSiteButton;
	
	@FindBy(css = "svg[class='gridicon gridicons-cross']")
	public WebElement deleteLinkButton;

	@FindBy(xpath = "//span[contains(text(), 'That link is already in your profile links. No changes were made.')]")
	public WebElement errorMessage;
	
	@FindBy(xpath = "//button[contains(text(), 'Cancel')]")
	public WebElement cancelButton;
	
	@FindBy(css = ".profile-links-add-other")
	public WebElement linkInputField;
	
	@FindBy(xpath = "//button[contains(text(), 'Add WordPress Site')]")
	public WebElement addWordPressSiteLink;

	@FindBy(xpath = "//button[text()='Create Site']")
	public WebElement createSiteButton;
	
	@FindBy(linkText = "Jetpack")
	public WebElement jetpackLink;

}
