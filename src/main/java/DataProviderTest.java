import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	public static WebDriver driver;

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" } };
	}

	@Test(dataProvider = "Authentication")
	public void test(String username, String password) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.store.demoqa.com");

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		// Argument passed will be used here as String Variable

		driver.findElement(By.id("log")).sendKeys(username);

		driver.findElement(By.id("pwd")).sendKeys(password);

		driver.findElement(By.id("login")).click();

		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

		driver.quit();
	}

}
