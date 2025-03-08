package Utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtilities
{
	public void captureFailureScreenshot(WebDriver driver,String name) throws IOException//to take screenshot of failed test cases
	{
		TakesScreenshot scrShot=(TakesScreenshot)driver;//webdriver cannot take screenshot so we are using takescreenshot interface
		File screenshot=scrShot.getScreenshotAs(OutputType.FILE);
		File f1=new File(System.getProperty("user.dir")+"\\outputScreenshots");
		if(!f1.exists())
		{
			f1.mkdirs();
		}
	String timestamp=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date(0));
	File finalDestination=new File(System.getProperty("user.dir")+"\\outputScreenshots\\"+name+"_"+timestamp+".pmg");
	FileHandler.copy(screenshot,finalDestination);//copy screenshot to our storage space
	
	}

}
