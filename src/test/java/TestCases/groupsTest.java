package TestCases;

import org.testng.annotations.Test;


public class groupsTest {
	
	@Test(groups = {"Regression"})
	public void test() {
		
	}
	
	@Test(groups = {"Smoke"})
	public void test2() {
		
	}
	
	@Test(groups = {"Smoke"})
	public void test3() {
		
	}
	
	@Test(groups = {"Regression", "Integration"})
	public void test4() {
		
	}

}


