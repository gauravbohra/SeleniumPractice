import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert {
	
	public static WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\GauravWorkSpace\\selenium.webdriver\\src\\test\\java\\webDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Starting Test On Chrome Browser");
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
		System.out.println("After completed method");
	}
	
	@Test
	public void openBrowser() {
		driver.get("https://www.demoqa.com");
		SoftAssert softAssert=new SoftAssert();
		String expectedTitle = "Free QA Automation Tools For Everyone";
        String originalTitle = driver.getTitle();
        softAssert.assertEquals(originalTitle, expectedTitle);
        softAssert.assertEquals(originalTitle, "ToolsQA" );
        
        softAssert.assertAll();
	}
	
}
