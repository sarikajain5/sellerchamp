package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By.ByXPath;
import base.Base;
public class Profile
{
	WebDriver driver ;
	WebDriverWait wait ;
	//Base base = new Base();
	Login login = new Login();
	ByXPath ebay = new ByXPath("//*[@id='navitems-settings']/ul/li[4]/a[@xpath='1']");
	ByXPath product = new ByXPath("//*[@id='navitem-products']/a[text()='Products']");

	ByXPath sku = new ByXPath("//a[@href='http://www.ebay.com/itm/110554175944']//parent::div//following-sibling::div[2]//child::div//child::input[@data-key='sku']");

	ByXPath searchInput = new ByXPath("//input[@id='product_query']");

	ByXPath searchButton = new ByXPath("//span//button[@data-disablewith='Searching...']");

	ByXPath downloadButton = new ByXPath("//button[@id='btn-download-products-toggle']");

	ByXPath productReport = new ByXPath("//a[@data-target='#product-report']");

	ByXPath submitButton = new ByXPath("//*[@id='new_product']/div/div[3]/div[2]/input");
	
	public Profile() 
	{
		System.out.println("into profile constructor");
		driver= login.getDriverForLogin();
		
	}
	
	public void clickEbay()
	{
	      driver.findElement(ebay).click();
	} 
	
	public void clickProduct()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOf((WebElement) product));
	    driver.findElement(product).click();
	      
	} 
	public String getSKU()
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOf((WebElement) sku));
	      return driver.findElement(sku).getText();
	} 
	public void sendToSearchInput(String skuValue)
	{
		wait = new WebDriverWait(driver,Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOf((WebElement) sku));
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
		wait.until(ExpectedConditions.elementToBeClickable((WebElement) downloadButton));
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
		wait.until(ExpectedConditions.elementToBeClickable( submitButton));
	      driver.findElement(submitButton).click();
	}
	
}
