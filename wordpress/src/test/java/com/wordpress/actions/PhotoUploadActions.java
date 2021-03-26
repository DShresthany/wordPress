package com.wordpress.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wordpress.elements.PhotoUploadElements;
import com.wordpress.utilities.SetupDrivers;

public class PhotoUploadActions {

	PhotoUploadElements pelements;
	public String publicName;

	public PhotoUploadActions() {
		this.pelements = new PhotoUploadElements();
		PageFactory.initElements(SetupDrivers.driver, pelements);
	}

	public void clickuploadBtn() {
		
		pelements.uploadLink.click();
		
	}
	
	public void uploadPhoto() throws AWTException {
	    String s = System.getProperty("user.dir");
		StringSelection ss = new StringSelection(s + "\\src\\test\\resources\\uploadfiles\\photo.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.delay(250);
	     SetupDrivers.driver.findElement(By.xpath("//button[contains(text(),'Change My Photo')]")).click();
		
	}
	
	public Boolean verifysuccessfulUpload() throws InterruptedException {
		Boolean bool =false;
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(pelements.uploadedMessage));
		if(pelements.uploadedMessage.isDisplayed()) {
			bool=true;
		}
		return bool;
	}
	
	public Boolean verifyPhotoPresent() {
		Boolean bool = false;
		
		
		return bool;
		
	}

	public void clickIicon() {
		publicName = getPublicName();
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(pelements.iIcon));
		pelements.iIcon.click();
	}

	public Boolean verifyMessage() {
		Boolean bool = false;
		if (pelements.message.isDisplayed()) {
			bool = true;
		}

		return bool;

	}

	public String getPublicName() {
		String publicname = pelements.displayName.getText();
		return publicname;
	}

	public void clickGravatarLink() {
		pelements.gravatarLink.click();
	}

	public Boolean verifyGravatarTab() {
		Boolean bool = false;
		String actualchildUrl;
		String parentWindow = SetupDrivers.driver.getWindowHandle();

		Set<String> windows = SetupDrivers.driver.getWindowHandles();

		for (String childWindow : windows) {
			if (!parentWindow.equals(childWindow)) {
				SetupDrivers.driver.switchTo().window(childWindow);
				actualchildUrl = SetupDrivers.driver.switchTo().window(childWindow).getCurrentUrl();
				if (actualchildUrl.contains(publicName)) {
					bool = true;
				}
			}

		}
		return bool;

	}

}
