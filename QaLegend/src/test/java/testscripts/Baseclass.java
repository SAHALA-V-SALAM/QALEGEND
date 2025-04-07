package testscripts;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import Utilities.ScreenshotUtilities;

public class Baseclass {
	public WebDriver driver;//call web browser
	
	public WebDriver initializemethod (String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();//revoke a webdriver
		}
		else if (browser.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid browser name");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	@AfterMethod
public void afterMethod(ITestResult itResult) throws IOException
{
	if(itResult.getStatus()==ITestResult.FAILURE)
	{
	ScreenshotUtilities sc=new ScreenshotUtilities();
	sc.captureFailureScreenshot(driver, itResult.getName());
}
	if(driver!=null)//if driver is not closed
	{
		driver.quit();//new browser is opened 
	}
}
}




