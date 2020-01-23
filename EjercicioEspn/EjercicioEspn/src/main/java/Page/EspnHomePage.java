package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class EspnHomePage extends BasePage{

	public EspnHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		driver.get("http://www.espn.com/?src=com");
	}

	@FindAll({ @FindBy(name = "&lpos=sitenavdefault+sitenav_nfl"), @FindBy(css ="a[name='&lpos=sitenavdefault+sitenav_nfl']"),
		@FindBy(xpath = "//a[@name='&lpos=sitenavdefault+sitenav_nfl']") })
	private WebElement nflBtnLocator;
	

	
	public NflPage initialSubmit() {
		Actions builder = new Actions(getDriver());
		builder.moveToElement(nflBtnLocator).build().perform();
		//click(nflBtnLocator);
		return new NflPage(getDriver());
	}
	
	public String getString() {
		return "espnHome";
	}
	
}
