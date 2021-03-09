import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {

	@Test
	@Parameters({ "val1", "val2" })
	public void sum(int val1, int val2) {
		System.out.println("Sum of values: " + (val1 + val2));
	}

	@Test
	@Parameters({ "val1", "val2" })
	public void diff(int val1, int val2) {
		System.out.println("Sum of values: " + (val1 - val2));
	}
}
