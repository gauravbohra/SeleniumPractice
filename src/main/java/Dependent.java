import org.testng.annotations.Test;

public class Dependent {

	
	@Test
	public void signIn() {
		System.out.println("User signed in");
	}

	@Test()
	public void openBrowser() {
		System.out.println("Browser opened");
	}
	
	@Test(dependsOnMethods= {"openBrowser","signIn"})
	public void logOut() {
		System.out.println("User logged out");
	}

}

