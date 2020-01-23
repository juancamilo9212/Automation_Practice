package Connection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class myDriver {
private WebDriver driver;
	
	public myDriver(String browser) {
		switch(browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./src/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();	
			break;
		case "chrome" :
			System.setProperty("webdriver.chrome.driver","./src/chromedriver2/chromedriver.exe");
			driver=new ChromeDriver();
			break;
			default:
			break;
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}

//<parameter name="browser" value="chrome"></parameter>