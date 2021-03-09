import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

public class SeleniumScreenShot {

	public static void main(String[] args) {
		String chromeDriverPath = System.getProperty("user.dir") + "/src/test/java/webDriver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		options.setCapability(chromeDriverPath, options);

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

		driver.findElement(By.xpath("//img[@alt='Google']//following::input[@title='Search']"))
				.sendKeys("Screenshot in senium");

		driver.findElement(
				By.xpath("//input[contains(@aria-label,'Lucky')]//preceding::input[@value='Google Search'][2]"))
				.click();

		TakesScreenshot screenShot = (TakesScreenshot) driver;

		try {
			File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/Screen.png");
			Files.copy(srcFile, destFile);
//			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			driver.quit();
				
		}

		}

}
