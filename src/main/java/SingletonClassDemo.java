import org.openqa.selenium.WebDriver;

public class SingletonClassDemo {

	private static SingletonClassDemo instance = null;

	private SingletonClassDemo() {
	}

	public static SingletonClassDemo getInstance() {
		if(instance==null) {
			instance=new SingletonClassDemo();
		}
		return instance;
	}
	
	static WebDriver driver;
	public static void main(String[] args) {
		driver=SingletonWebDriver.getInstance().getWebDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.quit();
	}
}
