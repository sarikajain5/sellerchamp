import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import page.Login;
import page.Profile;
public class LoginPageTest
{
	
	WebDriver driver;
	Login login;
	Profile profile;
	String Url;
	String SKU;
   @BeforeSuite
   public void driverInitalize()
   {
	   Url="http://qa.sellerchamp.com/users/sign_in";
		login = new Login(driver);
		//profile= new Profile();
		login.getUrl(Url);
	   
   }
   @Test
   public void loginToApplication()
   {
	   login.setUserId("admin@ncubeecomm.com");
	   login.setPassword("Shared@123456");
	   login.clickSubmit();
	   login.clickDropDown();
	   login.clickEbay();
	   login.clickProduct();
	   SKU=login.getSKU();
	   System.out.println("sku "+SKU);
	   login.sendToSearchInput(SKU);
	   login.clickSubmitButton();
	   login.clickDownloadButton();
	   login.clickProductReportButton();
	   login.clickSearch();
	   login.openCsv();
	   login.editMode();
	   login.verifyCSV();
   }
}
