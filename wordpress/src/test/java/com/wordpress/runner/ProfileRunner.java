package com.wordpress.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class ProfileRunner {

  @CucumberOptions(plugin = {"pretty", "html:target/cucumber-HTMLreports",
      "json:target/cucumber-jsonreports/cucumber.json"}, features = {
      "src/test/java/features/"},
      glue = {"wordpressprofile.stepdefinitions"}, tags = {}, monochrome = true)

  public static class RunCucumberTest extends AbstractTestNGCucumberTests {

  }
}
