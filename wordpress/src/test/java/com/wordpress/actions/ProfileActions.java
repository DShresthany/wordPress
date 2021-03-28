package com.wordpress.actions;

import com.wordpress.elements.ProfileElements;
import com.wordpress.utilities.PropertiesLoader;
import com.wordpress.utilities.SetupDrivers;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfileActions {

  private static final String USERNAME = PropertiesLoader.getInstance()
      .getPropertyValue("test_username");
  private static final String PASSWORD = PropertiesLoader.getInstance()
      .getPropertyValue("test_password");

  private static final String START_URL = PropertiesLoader.getInstance()
      .getPropertyValue("start_url");

  private static final String DEFAULT_TIMEOUT = PropertiesLoader.getInstance()
      .getPropertyValue("default_timeout");

  public String publicName;
  ProfileElements elements;

  public ProfileActions() {
    this.elements = new ProfileElements();
    PageFactory.initElements(SetupDrivers.driver, elements);
  }

  public void getWordPressProfilePage() {
    SetupDrivers.driver.get(START_URL);
    SetupDrivers.driver.manage().window().maximize();
    SetupDrivers.driver.manage().timeouts()
        .implicitlyWait(Integer.parseInt(DEFAULT_TIMEOUT), TimeUnit.SECONDS);
  }

  public String getFirstName() {
    return elements.firstName.getText();
  }

  public String getLastName() {
    return elements.lastName.getText();
  }

  public String getPublicName() {
    return elements.displayName.getText();
  }

  public String getAboutMe() {
    return elements.description.getText();
  }

  public void enterUserName() {
    elements.username.sendKeys(USERNAME);
  }

  public void clickContinueBtn() {
    elements.continueLoginButton.click();
  }

  public void enterPassword() {
    elements.password.sendKeys(PASSWORD);
  }

  public boolean verifyProfile() {
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
    boolean bool = false;
    WebElement pubName = SetupDrivers.driver
        .findElement(By.xpath("//h2[text()='" + publicName + "']"));
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
    boolean bool = false;
    String parentWindow = SetupDrivers.driver.getWindowHandle();
    Set<String> windows = SetupDrivers.driver.getWindowHandles();
    for (String childWindow : windows) {
      if (!parentWindow.equals(childWindow)) {
        SetupDrivers.driver.switchTo().window(childWindow);
        System.out.println("Child Window Handler: " + childWindow);
        System.out.println(
            ">> Child Window title: " + SetupDrivers.driver.switchTo().window(childWindow)
                .getTitle());
      }
    }
    if (windows.size() > 1) {
      bool = true;
    }
    return bool;
  }

  public Boolean verifyProfileInfoTab() {
    boolean bool = false;
    if (SetupDrivers.driver.getTitle().contains(publicName)) {
      bool = true;
    }

    return bool;

  }

  public void clickSaveButton() {
    elements.saveButton.click();
  }

  public boolean verifySaveAction() {
    boolean flag = false;
    if (elements.successNotification.isDisplayed()) {
      flag = true;
    }
    return flag;
  }

  public Boolean verifyUsernameWithPublicName() {
    boolean bool = false;
    String publicName = elements.displayName.getAttribute("value");
    System.out.println(publicName);
    if (publicName.equals(USERNAME)) {
      bool = true;
    }

    return bool;

  }

  public void clickGravatarLink() {
    elements.gravatarLink.click();
  }

  public Boolean verifyNewGravatarWindow() {
    boolean bool = false;
    String actualChildUrl = null;
    String expectedChildUrl = null;
    String parentWindow = SetupDrivers.driver.getWindowHandle();

    Set<String> windows = SetupDrivers.driver.getWindowHandles();

    for (String childWindow : windows) {
      if (!parentWindow.equals(childWindow)) {
        SetupDrivers.driver.switchTo().window(childWindow);
        actualChildUrl = SetupDrivers.driver.switchTo().window(childWindow).getCurrentUrl();
        expectedChildUrl = "http://en.gravatar.com/support/profile-hovercards/";
      }

      if (null != actualChildUrl && actualChildUrl.equals(expectedChildUrl)) {
        bool = true;
      }

    }
    return bool;

  }
}