import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.ExcelUtils;

import org.testng.annotations.DataProvider;

public class DataProviderWithExcel {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.store.demoqa.com");
		
	}
	

	 @Test(dataProvider="Authentication")
	 public void Registration_data(String username,String password) {
			driver.findElement(By.xpath(".//*[@id='account']/a")).click();

			// Argument passed will be used here as String Variable

			driver.findElement(By.id("log")).sendKeys(username);

			driver.findElement(By.id("pwd")).sendKeys(password);

			driver.findElement(By.id("login")).click();

			driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	 }
	 
	 @DataProvider
	 public Object[][] Authentication(){
		 Object[][] testObjArray=ExcelUtils.getTableArray("D://ToolsQA//OnlineStore//src//testData//TestData.xlsx","Sheet1");
		 return testObjArray;	
	 }
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
}
