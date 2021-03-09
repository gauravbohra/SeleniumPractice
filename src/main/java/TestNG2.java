import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG2 {
	WebDriver driver;

	@Test(groups= {"demoToolsQA"})
	public void f() {

		String baseUrl = "https://www.toolsqa.com/";
		System.out.println("Launching Mozilla Firefox browser");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String testTitle = "Free QA Automation Tools Tutorial for Beginners with Examples";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, testTitle);
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before classs TestNG2");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class TestNG2");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\GauravWorkSpace\\selenium.webdriver\\src\\test\\java\\webDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		System.out.println("Starting Test On Firefox Browser");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
