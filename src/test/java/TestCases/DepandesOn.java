package TestCases;

import org.testng.annotations.Test;

public class DepandesOn {
	
	
	
	@Test(dependsOnMethods = {"OpenBrowser"}, dependsOnGroups= {"smoke"})
	public void SignIn() {
		System.out.println("This will execute depending on the success of the Open Browser");

	}
	
	
	@Test(dependsOnGroups= {"Smoke"}, groups = {"Smoke"})
	public void OpenBrowser() {
		System.out.println("This will execute first (Open Browser)");
	//	AssertJUnit.assertTrue(false);

	}


}
	


