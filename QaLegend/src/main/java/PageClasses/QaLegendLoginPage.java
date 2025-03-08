package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;

import org.openqa.selenium.WebElement;
public class QaLegendLoginPage 
{

	WebDriver driver;
	@FindBy(id="username")
	WebElement usernamefield;
	@FindBy(id="password")
	WebElement passwordfield;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement loginbutton;
	
	
		public QaLegendLoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
	public void loginToQaLegend(String username,String password) throws InterruptedException
	{
		Thread.sleep(3000);
		Pageutilities.enterText(usernamefield, username);
		Pageutilities.enterText(passwordfield, password);
		Pageutilities.clickOnAnElement(loginbutton);
	}
	

}
