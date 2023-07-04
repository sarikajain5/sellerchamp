package page;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class Login extends Base
{
	
	WebDriver driver ;
	WebDriverWait wait ;
	 BufferedReader br;
	 CSVParser parser;
	ByCssSelector userId= new ByCssSelector("#user_email");
	ByCssSelector password= new ByCssSelector("#user_password");
	ByCssSelector submitBttn= new ByCssSelector("input.btn");
	ByXPath ebay = new ByXPath("//*[@id='navitems-settings']/ul/li[4]/a[@href='JavaScript:void(0)']");
	ByXPath product = new ByXPath("//*[@id='navitem-products']/a[text()='Products']");
	ByXPath selling = new ByXPath("//*[@aria-controls ='#panel-selling-details']") ;

	
	ByXPath sku = new ByXPath("//input[@data-key='sku'][@data-id='6489e04b354ad37115639ea6' ]");

	ByXPath searchInput = new ByXPath("//input[@id='product_query']");

	ByXPath searchButton = new ByXPath("//span//button[@data-disablewith='Searching...']");

	ByXPath downloadButton = new ByXPath("//button[@id='btn-download-products-toggle']");

	ByXPath productReport = new ByXPath("//a[@data-target='#product-report']");

	ByCssSelector submitButton = new ByCssSelector("span>button#btn-products-search");
	ByXPath dropDown = new ByXPath("//*[text()=' Sandbox eBay']");
	ByXPath submit = new ByXPath("//input[@name='Submit']");
	ByXPath editMode = new ByXPath("//i[@data-original-title='Edit']//parent::a[@data-mode='edit_product']");
	ByXPath Quantity =new ByXPath("//input[@name='product_listing[quantity_available]']");
	public Login(WebDriver driver) 
	{
		super(driver);
		setDriver();
		
	}
	public Login()
	{
		
	}
	public void setDriver()
	{
		driver=getDriver();
	}
	public WebDriver getDriverForLogin()
	{
		return getDriver();
	}
	public void setUserId(String userName)
	{
	      driver.findElement(userId).sendKeys(userName);
	}
	public void setPassword(String password)
	{
	      driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickSubmit()
	{
	      driver.findElement(submitBttn).click();
	}
	public void getUrl(String url)  
	 {  
		loginToUrl(url);
	 } 
	
	
	public void clickDropDown()
	{
	      driver.findElement(dropDown).click();
	} 
	
	public void clickEbay()
	{
	      driver.findElement(ebay).click();
	} 
	
	public void clickProduct()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
	    driver.findElement(product).click();
	      
	} 
	public String getSKU()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated( sku));
	      return driver.findElement(sku).getAttribute("value");
	} 
	public void sendToSearchInput(String skuValue)
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated( sku));
	      driver.findElement(searchInput).sendKeys(skuValue);
	} 
	public void clickSearchButton()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.elementToBeClickable((WebElement) searchButton));
	      driver.findElement(searchButton).click();
	} 
	public void clickDownloadButton()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated( downloadButton));
	      driver.findElement(downloadButton).click();
	} 
	public void clickProductReportButton()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
	      driver.findElement(productReport).click();
	} 
	public void clickSubmitButton()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated( submitButton));
	      driver.findElement(submitButton).click();
	}
	public void clickSearch()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated( submit));
	      driver.findElement(submit).click();
	}
	public void editMode()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated( editMode));
	      driver.findElement(editMode).click();
	}
	public void openCsv()
	{
		/*try {
			/* FileReader filereader = new FileReader("c:/inventory.csv");
			  
		        // create csvReader object passing
		        // file reader as a parameter
		        CSVReader csvReader = new CSVReader(filereader);
		        String[] nextRecord;
		  
		        // we are going to read data line by line
		        while ((nextRecord = csvReader.readNext()) != null) {
		            for (String cell : nextRecord) {
		            	
		                System.out.print(cell + "\t");
		            }
		            System.out.println();
		        }
		    }
		    catch(IOException ioe) {
		      ioe.printStackTrace();
		    }
			
			
	}*/
	
	 try
	 {
		 br = new BufferedReader(new FileReader("c:/inventory.csv"));
	 
         parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);
        
    } 
	 catch (Exception e)
	 {
       System.out.println(e);
     }
	}


public void verifyCSV()
{
	try
	{
		ByXPath EbayItemCondition = new ByXPath("//*[@id='product_listing_ebay_item_condition_id']");
		Select itemconditionSelect = new Select(driver.findElement(EbayItemCondition));
		String itemcondition = itemconditionSelect.getFirstSelectedOption().getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");		
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.elementToBeClickable(selling));
		driver.findElement(selling).click();
	 String quantityAvailable = driver.findElement(Quantity).getAttribute("value");
     for(CSVRecord record : parser)
     {
  	   
      Assert.assertEquals(record.get("QUANTITY AVAILABLE"), quantityAvailable );
     Assert.assertEquals(record.get("EBAY ITEM CONDITION TEXT"),itemcondition);
     }
} 
catch (Exception e)
{
 System.out.println(e);
}
}
	
}
