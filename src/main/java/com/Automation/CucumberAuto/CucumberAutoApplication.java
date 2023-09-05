package com.Automation.CucumberAuto;

	import org.openqa.selenium.WebDriver;

	import io.cucumber.core.cli.Main;

	public class CucumberAutoApplication {

		public static WebDriver driver;
		public static void main(String args[]) throws Throwable {
		    try {
		        Main.main(new String[] { 		    
         
		        		
		        "-g","com.Automation.CucumberAuto",
		  
		        "-g","com.Automation.CucumberAuto.Stepdefination",
		        "-g","com.Automation.CucumberAuto.testng.runner",		                    
		        "src/main/resources/features/WeblogicConnect.feature", 		        
		        "-t","@SmokeTest",		        
		                
		        "-p", "pretty", 
		        "-p", "json:target/cucumber-reports/cucumber.json", 
		  //      "-p", "html:target/cucumber-reports/cucumberreport.html",s
		        
		        "-m"
		    }
		    );
		} catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("Main method exception : " + e);
		}
		}

	}
