import org.testng.annotations.Test;

public class DataProvider {

	@Test(dataProvider="data-provider", dataProviderClass=DataPro.class)
	public void myTest(String val1) {
		System.out.println("Value passed: "+ val1);
	}
}
