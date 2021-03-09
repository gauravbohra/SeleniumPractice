import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebDriver {

	private static SingletonWebDriver singletonInstance = null;
	private WebDriver driver;

	private SingletonWebDriver() {

	}

	public WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/java/webDriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static SingletonWebDriver getInstance() {
		if (singletonInstance == null) {
			singletonInstance = new SingletonWebDriver(); //Lasy initialization
		}
		return singletonInstance;
	}

}
