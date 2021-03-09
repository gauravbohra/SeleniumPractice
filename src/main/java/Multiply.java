import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Multiply {
	@Test
	@Parameters({ "val1", "val2" })
	public void diff(int val1, int val2) {
		System.out.println("Sum of values: " + (val1 * val2));
	}
}
