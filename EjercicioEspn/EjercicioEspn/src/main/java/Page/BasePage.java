package Page;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,15);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	
	public WebDriverWait getWait() {
		return wait;
	}

	public void dispose() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	
	public void waitForPageLoad() {
		ExpectedCondition<Boolean> expectation=new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(expectation);
		}catch(Throwable error){
			System.out.println("Timeout waiting for Page Load Request to complete.");
	        }
	}
	
	public boolean isStale(WebElement element) {
		boolean isStale=true;
		int retries=0;
		while(retries<5 && isStale==true) {
			try {
				element.getSize();
				isStale=false;
			}catch(StaleElementReferenceException e) {
				System.out.println("Retrying in stale status");
		        retries++;
			}
		}
		return isStale;
	}
	
	public void click(WebElement element) {
		waitForPageLoad();
		isStale(element);
		getWait().until(ExpectedConditions.visibilityOf(element));
		getWait().until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	
	public void sendKeys(WebElement element,String inputText) {
		waitForPageLoad();
		getWait().until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(inputText);
	}
	
	public String getText(WebElement element) {
		waitForPageLoad();
		getWait().until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	public String mainWindowHandle() {
		waitForPageLoad();
		return driver.getWindowHandle();
	}
	
	public void handlePopUps(String valor,String handle) {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for(String s:tabs) {
			System.out.println("Tamano=" + tabs.size() +" "+ valor +" "+ s);
		}
		for(int i=0;i<tabs.size();i++) {
			if(!(handle.equals(tabs.get(i)))){
				driver.switchTo().window(tabs.get(i));
				driver.close(); 
			}
		}
	}
	
	
}
