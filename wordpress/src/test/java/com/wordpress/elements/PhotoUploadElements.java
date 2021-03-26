package com.wordpress.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoUploadElements {
	
	@FindBy(id = "display_name")
	public WebElement displayName;

	@FindBy(css = "span[class='edit-gravatar__label']")
	public WebElement uploadLink;
	
	@FindBy(css = ".gridicon.gridicons-info-outline.needs-offset")
	public WebElement iIcon;
	
	@FindBy(css = ".popover__inner")
	public WebElement message;
	
	@FindBy(css = "	a[class='external-link has-icon']")
	public WebElement gravatarLink;
	
	
	@FindBy(xpath = "//span[contains(text(),'looking sharp!')]")
	public WebElement uploadedMessage;
	
	

}
