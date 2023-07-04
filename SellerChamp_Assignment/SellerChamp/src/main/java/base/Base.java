package base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{
	
	
    WebDriver driver;
	WebDriverWait wait;
	public Base(WebDriver driver)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
    	options.setAcceptInsecureCerts(true);
    	this.driver=new ChromeDriver(options);
    	
	}
	public Base()
	{
		
	}
	
	protected void loginToUrl(String url)
	{	
    	
    	try 
    	{
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   }
    	catch (Exception e)
    	{
			
			e.printStackTrace();
		}    	 
    	
    	
    
	}	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	
	

}
