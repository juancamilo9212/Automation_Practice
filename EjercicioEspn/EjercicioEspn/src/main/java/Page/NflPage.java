package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class NflPage extends BasePage{

	public NflPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindAll({ @FindBy(name = "&lpos=sitenavdefault+nfl_nflstandings"), @FindBy(css = "a[name='&lpos=sitenavdefault+nfl_nflstandings']  "),
		@FindBy(xpath = "//a[@name='&lpos=sitenavdefault+nfl_nflstandings']") })
	private WebElement standingsBtnLocator;
	
	public StandingsPage submitStandings() {
		click(standingsBtnLocator);
		return new StandingsPage(getDriver());
	}
	
}
