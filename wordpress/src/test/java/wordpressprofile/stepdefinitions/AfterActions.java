package wordpressprofile.stepdefinitions;

import com.wordpress.utilities.SetupDrivers;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AfterActions {

  private static final Logger logger = LogManager.getLogger(AfterActions.class);

  @After
  public void afterScenario(Scenario scenario) {
    System.out.println("..Test Ended..");
    try {
      if (scenario.isFailed()) {
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        TakesScreenshot ts = (TakesScreenshot) SetupDrivers.driver;
        byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotBytes, "image/png", screenshotName);
      }
    } catch (Exception e) {
      logger.error("Error running after scenario", e);
      e.printStackTrace();
    }

    SetupDrivers.closeChromeDriver();
		logger.info("Browser closed");
  }
}
