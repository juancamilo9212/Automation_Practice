package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class StandingsPage extends BasePage{

	public StandingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindAll({ @FindBy(css = "select[class='dropdown__select'][css='3']"),
		@FindBy(xpath = "//select[@class='dropdown__select' and @style='text-overflow: ellipsis; overflow: hidden; width: 104px;']") })
	private WebElement rsrcDpdnLocator;
	
	public PlayOffPage selectPlayOff() {
		selectOption(rsrcDpdnLocator,"Playoff Machine");
		return new PlayOffPage(getDriver());
	}

	public void selectOption(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public String getString() {
		return "Standings";
	}
}
