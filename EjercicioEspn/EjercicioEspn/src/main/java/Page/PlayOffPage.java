package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class PlayOffPage extends BasePage{

	public PlayOffPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindAll({ @FindBy(css = "h2[class='logo']"),
		@FindBy(xpath = "//h2[@class='logo']") })
	private WebElement PlayOffLogoLocator;
	
	public boolean isDisplayed(WebElement element) {
		 return element.isDisplayed();
	 }
	
	public WebElement getLogo() {
		return PlayOffLogoLocator;
	}
	
	public String getString() {
		return "PlayOff";
	}

	
}
