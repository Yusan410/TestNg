package TestCases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PrametersTest {
	@Parameters({"Val1","Val2"})
	@Test
	public void sumOf(int v1,int v2) {
		
		
		
	int finalsum = v1+v2;
	
	System.out.println("Sum of value "+finalsum);
	
	}
	@Parameters({"Name1","Name2"})
	@Test
	public void Concat(String Fname,String Lname) {
		
		
		String concat = Fname+Lname;
		
		System.out.println("Full name is " +concat);
		
		
		
	}

}
