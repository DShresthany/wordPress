package wordpressprofile.stepdefinitions;

import com.wordpress.utilities.SetupDrivers;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeActions {

	@Before
	public void beforeScenario(Scenario scen) {
		
			System.out.println("..Driver initilization..");
			SetupDrivers.setupChromeDriver();
			System.out.println("..ChromeDriver initialized..");
			System.out.println("scene.getName");

	}

}
