package com.Automation.CucumberAuto.Stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//@CucumberContextConfiguration
//@SpringBootTest(classes = Configuration.class)
public class WeblogicConnectSteps {

    private WebDriver driver;
 //   private HashMap<String, String> tableData;
    private List<Map<String, String>> tableDataList = new ArrayList<Map<String, String>>();
    private List<Map<String, String>> tableDataList1 = new ArrayList<Map<String, String>>();
    private List<Map<String, String>> tableDataList2 = new ArrayList<Map<String, String>>();


    @Given("I navigate to {string}")
    public void iNavigateTo(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Configuration.getProperty("webdriver.chrome.driver.path"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    //    Thread.sleep(10000);
    }

    @And("I enter {string} in the username field")
    public void iEnterUsername(String username) {
        WebElement usernameField = driver.findElement(By.xpath(Configuration.getProperty("login.username.field.xpath")));
        usernameField.sendKeys(username);                       
    }

    @And("I enter {string} in the password field")
    public void iEnterPassword(String password) {   
        WebElement passwordField = driver.findElement(By.xpath(Configuration.getProperty("login.password.field.xpath")));
        passwordField.sendKeys(password);                       
    }        

    @And("I click the login button")
    public void iClickLoginButton() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath(Configuration.getProperty("login.button.xpath")));
        loginButton.click();
        Thread.sleep(2000);
		driver.findElement(By.id(Configuration.getProperty("app.deployments.link.id"))).click();

        
    }

    @When("I fetch the table data for {string}")
    public void iFetchTableData(String inputColumnAValue) {
     //   tableDataList = new ArrayList<Map<String, String>>();
        WebElement table = driver.findElement(By.id(Configuration.getProperty("datasource.table.id")));

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
         // Inside the for loop for rows
            if (cells.size() >= 7) {
                String columnAValue = cells.get(1).getText();
                String columnBValue = cells.get(2).getText();
               if (columnAValue.equals(inputColumnAValue)) {
                    Map<String, String> rowData = new HashMap<String, String>();
                    rowData.put("ColumnA", columnAValue);
                    rowData.put("ColumnB", columnBValue);
                    tableDataList.add(rowData);
                    break;
            }

            }
           

    }
    } 
    

    @Then("I display the output value")
    public void iDisplayOutputValue() throws InterruptedException {
		/*
		 * String inputColumnAValue = tableData.keySet().iterator().next(); String
		 * outputColumnBValue = tableData.get(inputColumnAValue);
		 */
        for (Map<String, String> tableData : tableDataList) {
    
  //  	for (Map.Entry<String, String> entry : tableData.entrySet()) {
            String inputColumnAValue = tableData.get("ColumnA");
            String outputColumnBValue = tableData.get("ColumnB");
            
        System.out.println("Input Value: " + inputColumnAValue);
        System.out.println("Output Value: " + outputColumnBValue);
    //    Thread.sleep(2000);    	
        }
	//     driver.quit();

    } 
         
	
	  @When("I enter in datasource {string}") 
	  public void iEnterDataSource(String dataSourceName) throws  InterruptedException {
	  

	  WebElement loginButton1 = driver.findElement(By.xpath(Configuration.getProperty("datasource.name.entry.symbol.link.xpath")));
	  loginButton1.click();
   //   Thread.sleep(10000);    	

	  
	  driver.findElement(By.id(Configuration.getProperty("datasource.name.link.click.xpath"))).click();
   //   Thread.sleep(10000);    	
	  
      WebElement table1 = driver.findElement(By.id(Configuration.getProperty("datasource.table.id")));
		      
      List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
      // Iterate through the rows to find the data source
      for (WebElement row1 : rows1) {
    	  
    	  
          List<WebElement> cells1 = row1.findElements(By.tagName("td"));
          if (cells1.size() >= 5) {
              String columnAValue = cells1.get(1).getText();

             if (columnAValue.equals(dataSourceName)) {

                  Map<String, String> rowData1 = new HashMap<String, String>();
                  rowData1.put("ColumnA", columnAValue);
                  tableDataList1.add(rowData1);
             
              WebElement applicationLink = cells1.get(1).findElement(By.tagName("a"));
              applicationLink.click();
              break;
             }
          }
      }   
                     	    
            	    driver.findElement(By.xpath(Configuration.getProperty("datasource.monitor.tab.xpath"))).click();
                    
          		  driver.findElement(By.xpath(Configuration.getProperty("datasource.statistics.tab.xpath"))).click();
          		  
                       

      }
                        
          
      
	  
	  
	    @And("I fetch the data source table data for {string}")
	    public void iFetchDataSourceTableData(String serverName)   {
    
	        WebElement table2 = driver.findElement(By.id(Configuration.getProperty("datasource.table.id")));
	        
	        	List<WebElement> rows2 = table2.findElements(By.tagName("tr"));
		        for (WebElement row2 : rows2) {
		       // 	try {
		            List<WebElement> cells2 = row2.findElements(By.tagName("td"));
		         // Inside the for loop for rows
		            if (cells2.size() >= 3) {
		                String columnAValue = cells2.get(1).getText();
		                String columnBValue = cells2.get(2).getText();		                
		               if (columnAValue.equals(serverName)) {
		                    Map<String, String> rowData2 = new HashMap<String, String>();
		                    rowData2.put("ColumnA", columnAValue);
		                    rowData2.put("ColumnB", columnBValue);
		                    tableDataList2.add(rowData2);
		                    break;
		            }

		            }
		     //       } catch (StaleElementReferenceException e) {
		            	
		            }

		    }
	         

	  
				
		  
	  
	 
	    @Then("I display the data source output value")
	    public void iDisplayDataSourceOutputValue()  {
		
	        for (Map<String, String> tableData2 : tableDataList2) {
	    
	            String inputColumnAValue1 = tableData2.get("ColumnA");
	            String outputColumnBValue1 = tableData2.get("ColumnB");
	            
	        System.out.println("Input Value: " + inputColumnAValue1);
	        System.out.println("Output Value: " + outputColumnBValue1);
	    //    driver.navigate().refresh();
	    //    driver.findElement(By.xpath("//*[@id=\"genericTableFormtable\"]")).click();
	        }
	    driver.close();

	    } 

		 
	  
}
	 
                                                
    


	



	             

