package com.wordpress.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class ProfileRunner {

	@CucumberOptions(plugin = { "pretty", "html:target/cucumber-HTMLreports",
			"json:target/cucumber-jsonreports/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, features = {
					"src/test/resources/wordPressFeatures" }, 
			glue = { "wordpressprofile.stepdefinitions" }, tags = {}, monochrome = true)
	
	public class RunCucumberTest extends AbstractTestNGCucumberTests {

	}
}
