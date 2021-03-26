package com.wordpress.actions;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wordpress.elements.ProfileLinksElements;
import com.wordpress.utilities.SetupDrivers;

public class ProfilelinksAction {

	ProfileLinksElements elements;
	public String addedUrl;
	public String addedDescription;

	public ProfilelinksAction() {
		this.elements = new ProfileLinksElements();
		PageFactory.initElements(SetupDrivers.driver, elements);
	}

	// To be completed
	public void deletAllLinks() throws InterruptedException{
	
		List<WebElement> linkstoDelete = SetupDrivers.driver.findElements(By.xpath("//button[@class='button profile-link__remove is-borderless']"));
		System.out.println("Number of Url Links present: " + linkstoDelete.size());
		if(linkstoDelete.size()>0) {
		for(WebElement li : linkstoDelete) {
//			WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 5);
//			wait.until(ExpectedConditions.elementToBeClickable(li));
			Thread.sleep(2000);
			if(li.isDisplayed()) {
			li.click();
		}
		}

	}
	}
	public void deleteLink(String Url) {
		WebElement delete = SetupDrivers.driver.findElement(By.cssSelector("a[href='" + Url + "']+button>svg>use"));
		delete.click();
	}

	public void clickAddLink(){
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 7);
		wait.until(ExpectedConditions.elementToBeClickable(elements.addButton));
		elements.addButton.click();
	}

	public void selectURL() {
		elements.addURLlink.click();
	}

	public Boolean verifyAddUrlbox() {
		Boolean bool = false;
		if (elements.enterUrlBox.isDisplayed()) {
			bool = true;
		}
		return bool;
	}

	public Boolean verifyAddDescriptionbox() {
		Boolean bool = false;
		if (elements.enterDescriptionBox.isDisplayed()) {
			bool = true;
		}
		return bool;
	}

	public void enterUrl(String url) {
		elements.enterUrlBox.sendKeys(url);
		this.addedUrl = url;
	}

	public String getUrl() {
		return addedUrl;
	}
	
	public String getDescription() {
		return addedDescription;
	}

	public void enterDescription(String description) {
		elements.enterDescriptionBox.sendKeys(description);
		this.addedDescription = description;
	}

	public void clickAddSiteButton() {
		elements.addSiteButton.click();
	}

	public Boolean verifyUrl() {
		Boolean bool = false;
		List <WebElement> elements = SetupDrivers.driver.findElements(By.cssSelector(".profile-link>a:nth-of-type(1)"));
		
		for(WebElement links : elements) {
			if(links.getAttribute("href").contains(addedUrl)) {
				bool = true;
				break;
			}
		}
	
		return bool;

	}
	
	
	public Boolean verfifyUrlOpens(String url) {
		Boolean bool = false;
		String parentWindow = SetupDrivers.driver.getWindowHandle();
		Set<String> windows = SetupDrivers.driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!parentWindow.equals(childWindow)) {
				SetupDrivers.driver.switchTo().window(childWindow);
				String actualUrl = SetupDrivers.driver.switchTo().window(childWindow).getCurrentUrl();
				if(actualUrl.equals(url)) {
					bool=true;
				}
				SetupDrivers.driver.quit();
			
			}
		}
		
		return bool;
		
	}

	public Boolean verifyDescription() {
		Boolean bool = false;
		WebElement actualdDescription = SetupDrivers.driver
				.findElement(By.cssSelector("span[class='profile-link__title']"));
		String description = actualdDescription.getText();

		if (description.equals(getDescription())) {
			bool = true;
		}
		return bool;
	}
	
	public Boolean verifyAddButtonDisabled(){
		
		Boolean bool = true;
		if(elements.addButton.isEnabled()) {
			bool = false;
		}
		return bool;
	}
	
	public Boolean verifyErrorMessage() {
		Boolean bool = false;
	
		if(elements.errorMessage.isEnabled()) {
			bool = true;
		}
		return bool;
	}
	
	public void clickCancelButton() {
		elements.cancelButton.click();
	}
	
	public Boolean verifyCancel() {
		Boolean bool = false;
		if(!elements.linkInputField.isDisplayed()) {
			bool=true;
		}
		return bool;
	}
	
	public void clickUrlLink(String url) {
		WebElement url1 = SetupDrivers.driver.findElement(By.cssSelector("a[href= '"+url+"'][class='profile-link__image-link']"));
		url1.click();
	}

	public void clickAddWordPressSite() {
//		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 7);
//		wait.until(ExpectedConditions.elementToBeClickable(elements.addWordPressSiteLink));
		elements.addWordPressSiteLink.click();
	}
	
	public void clickCreateSiteButton() {
		elements.createSiteButton.click();
	}
	
	public Boolean verfifyCreateSiteWindow() {
		Boolean bool = false;
		String parentWindow = SetupDrivers.driver.getWindowHandle();
		Set<String> windows = SetupDrivers.driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!parentWindow.equals(childWindow)) {
				SetupDrivers.driver.switchTo().window(childWindow);
				String actualUrl = SetupDrivers.driver.switchTo().window(childWindow).getCurrentUrl();
				if(actualUrl.equals("https://wordpress.com/new?ref=me-profile-links")) {
					bool=true;
				}
				SetupDrivers.driver.quit();
			
			}
		}
		
		return bool;
		
	}
	
	public void clickJetpackLink() {
		elements.jetpackLink.click();
	}
	
	public Boolean verifyJetpackPage() {
		Boolean bool = false;
		String parentWindow = SetupDrivers.driver.getWindowHandle();
		Set<String> windows = SetupDrivers.driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!parentWindow.equals(childWindow)) {
				SetupDrivers.driver.switchTo().window(childWindow);
				String actualUrl = SetupDrivers.driver.switchTo().window(childWindow).getTitle();
				if(actualUrl.contains("Jetpack")) {
					bool=true;
				}
				SetupDrivers.driver.quit();
			
			}
		}
		
		return bool;
		
	}
}
