package utilities;


import java.net.MalformedURLException;

import Pages.cusTomerfrontEnd;
import Pages.supplierPages;

public class PageInitilaizer extends BaseClass {
	
	
	public static supplierPages sup;
	
	public static cusTomerfrontEnd cus;
	
	
	
	public static void initilize() throws MalformedURLException {
		
		
		sup = new supplierPages();
		
		cus = new cusTomerfrontEnd();
		
		
		
		
		
		
		
	}

}
