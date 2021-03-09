

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Log4j {

	private static WebDriver driver;
	private static Logger logger=LogManager.getLogger();
	public static void main(String[] args) {
		logger.debug("Hello from Log4j 2");
		logger.debug("This is a Debug Message!");
		logger.info("This is an Info Message!");
	}

}
