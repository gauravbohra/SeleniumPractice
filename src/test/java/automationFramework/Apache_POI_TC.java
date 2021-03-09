package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Constant;

public class Apache_POI_TC {
	private static WebDriver driver = null;
	private static Logger log = LogManager.getLogger(Apache_POI_TC.class.getName());

	public static void main(String[] args) {
		Configurator.initialize(new DefaultConfiguration());
		Configurator.setRootLevel(Level.INFO);
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\GauravWorkSpace\\selenium.webdriver\\src\\test\\java\\webDriver\\chromedriver.exe");

//		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Sheet1");
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("chrome.switches","--disable-extensions");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constant.URL);
			log.info("URl launched");
//		String userName=ExcelUtils.getCellData(1, 1);
//		String password=ExcelUtils.getCellData(1, 2);

			driver.findElement(By.id("userName")).sendKeys("testuser_1");
			log.info("Username entered");
			driver.findElement(By.id("password")).sendKeys("Test@123");
			log.info("Password entered");
			driver.findElement(By.id("login")).click();
			Thread.sleep(10000);
			log.info("User logged in");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
//		ExcelUtils.setCellData("Pass", 1, 3);

	}

}
