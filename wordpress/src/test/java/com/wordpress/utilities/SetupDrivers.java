package com.wordpress.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupDrivers {

  public static WebDriver driver;

  public static void setupChromeDriver() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(new ChromeOptions().setHeadless(isHeadless()));
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public static void setupFirefoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public static void closeChromeDriver() {
    driver.quit();
  }

  /**
   * If a maven parameter is strictly specified, tests will run in Headless mode. (For CI
   * execution)
   */
  private static boolean isHeadless() {
    String value = System.getProperty("headless");
    if (null == value || value.isEmpty()) {
      return false;
    } else {
      return Boolean.parseBoolean(value);
    }
  }
}
