package wordpressprofile.stepdefinitions;

import com.wordpress.utilities.SetupDrivers;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeforeActions {

  private static final Logger logger = LogManager.getLogger(BeforeActions.class);

  @Before
  public void beforeScenario(Scenario scenario) {

    logger.info("..Driver initialization..");
    SetupDrivers.setupChromeDriver();
    logger.info("..ChromeDriver initialized..");
    logger.info("Running scenario: {}", scenario.getName());

  }

}
