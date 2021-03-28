# Tests for My profile page in Wordpress.

Test feature files are location in [features](https://github.com/user/repo/blob/branch/other_file.md) package.

## Pre-requisites
    - JDK 1.8
    - Maven (For compilation)

## Dependencies used in project: 

    - Selenium 3.XX webdriver
    - Cucumber (For BDD/Gherkin style)
    - Apache logger (For logging)
    - Extent reports (For reports)

## Test tags

All Tests have been grouped as following tags: 

    - @smoke: All high priority scenarios
    - @regression: Scenarios for regression testing

Feature specific tags: 

If you want to run test for a specific feature the following tags can be user:

    - @addUrl (All test scenarios for linking external URL to wordpress page)
    - @photoUpload (All test scenarios for uploading profile picture)
    - @profilePage(All test scenarios for updating profile details) 

## Running tests

Tests can be run via IDE or via command line via Maven. Some examples :

     $ mvn test  # This will run all existing tests   
     $ mvn test -Dcucumber.options="--tags '@smoke and @addUrl'"
        #This will run all smoke tests that are of Add Url scenarios
     $ mvn test -Dheadless=true # This will run all existing tests in headless mode (For CI execution)

## Call outs
 
The current test scenario for profile picture upload can only be run on a Windows machine (Since I am in a Windows machine). The upload modal in the wordpress page does not export an #input field which could have been user for cross-platform uploads. The workaround is to user the Robot class for selecting file uploads. 


