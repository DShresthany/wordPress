package com.wordpress.actions;

import com.wordpress.elements.PhotoUploadElements;
import com.wordpress.utilities.SetupDrivers;
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

public class PhotoUploadActions {

  private static final String UPLOAD_FILE_PATH = "src/test/resources/upload_files/photo.jpg";
  public String publicName;
  PhotoUploadElements photoUploadElements;

  public PhotoUploadActions() {
    this.photoUploadElements = new PhotoUploadElements();
    PageFactory.initElements(SetupDrivers.driver, photoUploadElements);
  }

  public void clickUploadBtn() {
    photoUploadElements.uploadLink.click();
  }


  public void uploadPhoto() throws AWTException {
//    String s = System.getProperty("user.dir");
    StringSelection ss = new StringSelection(new File(UPLOAD_FILE_PATH).getAbsolutePath());
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    Robot robot = new Robot();
    robot.delay(250);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.delay(90);
    robot.keyRelease(KeyEvent.VK_ENTER);
    robot.delay(250);
    SetupDrivers.driver.findElement(By.xpath("//button[contains(text(),'Change My Photo')]"))
        .click();
  }


  public Boolean verifySuccessfulUpload() throws InterruptedException {
    boolean bool = false;
    WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 30);
    wait.until(ExpectedConditions.visibilityOf(photoUploadElements.uploadedMessage));
    if (photoUploadElements.uploadedMessage.isDisplayed()) {
      bool = true;
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
    wait.until(ExpectedConditions.elementToBeClickable(photoUploadElements.iIcon));
    photoUploadElements.iIcon.click();
  }

  public Boolean verifyMessage() {
    boolean bool = false;
    if (photoUploadElements.message.isDisplayed()) {
      bool = true;
    }
    return bool;
  }

  public String getPublicName() {
    return photoUploadElements.displayName.getText();
  }

  public void clickGravatarLink() {
    photoUploadElements.gravatarLink.click();
  }

  public Boolean verifyGravatarTab() {
    boolean bool = false;
    String actualChildUrl;
    String parentWindow = SetupDrivers.driver.getWindowHandle();

    Set<String> windows = SetupDrivers.driver.getWindowHandles();

    for (String childWindow : windows) {
      if (!parentWindow.equals(childWindow)) {
        SetupDrivers.driver.switchTo().window(childWindow);
        actualChildUrl = SetupDrivers.driver.switchTo().window(childWindow).getCurrentUrl();
        if (actualChildUrl.contains(publicName)) {
          bool = true;
        }
      }

    }
    return bool;

  }

}
