import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before the suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After the suite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before classs TestNG");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class TestNG");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}
	
	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\GauravWorkSpace\\selenium.webdriver\\src\\test\\java\\webDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Starting Test On Chrome Browser");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("After completed method");
	}
	
	@Test(groups= {"demoToolsQA"})
	public void f1() {

		String baseUrl = "https://www.toolsqa.com/";
		System.out.println("Launching Google Chrome browser");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String testTitle = "Free QA Automation Tools Tutorial for Beginners with Examples";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, testTitle);
		System.out.println("f1 test passed");
		Reporter.log("f1 test passed");
	}


	@Test(priority=0,groups= {"demoUdemy"})
	public void f2() {

		String baseUrl = "https://www.udemy.com/";
		System.out.println("Launching Google Chrome browser");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String testTitle = "Online Courses - Learn Anything, On Your Schedule | Udemy";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, testTitle);
		System.out.println("f2 test passed");
		Reporter.log("f2 test passed");
		
	}


	

}
