
  package com.Automation.CucumberAuto.testng.runner;
    
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
  
  @CucumberOptions ( 
		  features = "classpath:features", 
		  glue = { "com.Automation.CucumberAuto.Stepdefination","com.Automation.CucumberAuto.testng.runner" },
		  plugin = {"pretty", "json:target/cucumber-report.json"},
		  tags = "@SmokeTest",
		  monochrome= true
		  )
  
  public class  CucumberTestRunner  extends AbstractTestNGCucumberTests{ }
  
  
 