package com.Automation.CucumberAuto.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/main/resources/features/WeblogicConnect.feature",  // Specify the path to your feature files
    glue = {"com.Automation.CucumberAuto.Stepdefination"},  // Specify the package where step definitions are located
    tags = "@SmokeTest",  // Specify the tag(s) for scenarios you want to run
    plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},  // Specify the reporting plugins
    monochrome =true
)
public class CucumberTestRunner  extends AbstractTestNGCucumberTests{
	
}
