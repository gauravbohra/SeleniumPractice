import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\GauravWorkSpace\\selenium.webdriver\\src\\test\\java\\webDriver\\geckodriver.exe");
			driver = new FirefoxDriver();

			System.out.println("Starting Test On Firefox Browser");
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\GauravWorkSpace\\selenium.webdriver\\src\\test\\java\\webDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Starting Test On Chrome Browser");
		}
		// Enter the website address in the browser

		driver.get("https://www.demoqa.com");

	}

	// Once Before method is completed, Test method will start

	@Test
	public void login() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();

	}

	@AfterClass
	public void afterTest() {

		driver.quit();

	}
}
