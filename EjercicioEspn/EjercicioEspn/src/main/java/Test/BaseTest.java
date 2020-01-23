package Test;




import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Connection.myDriver;
import Page.EspnHomePage;

public class BaseTest {

	myDriver myDriver;
	private EspnHomePage page;
	
	
	    @Parameters({"browser"})
		@BeforeClass
		public void beforeTest(String browser) {
			myDriver = new myDriver(browser);
			page=new EspnHomePage(myDriver.getDriver());
			page.maximize(myDriver.getDriver());
			
		}
	
	@AfterClass
	public void afterMethod(){
		page.dispose();
	}
	
	public EspnHomePage homePage() {
		return page;
	}
	
	
}
