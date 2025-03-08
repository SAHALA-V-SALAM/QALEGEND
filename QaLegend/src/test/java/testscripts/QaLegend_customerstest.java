package testscripts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClasses.QaLegendCustomerPage;
import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendLoginPage;
import Utilities.Fakerutility;

public class QaLegend_customerstest extends Baseclass

{
	WebDriver driver;
	QaLegendLoginPage loginpage;
	QaLegendHomePage homepage;
	QaLegendCustomerPage customerpage;
	Properties prop;
	FileInputStream fis;
	@BeforeMethod
	public void browserInitialization() throws Exception// camel casing
	{
		driver=initializemethod("chrome");
		prop=new Properties();
		String path= System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\data.properties";//to get dynamic path
		fis=new FileInputStream(path);
		prop.load(fis);//to load property file to prop
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginpage=new QaLegendLoginPage(driver);
		homepage=new QaLegendHomePage(driver);
		customerpage=new QaLegendCustomerPage(driver);
	}
@Test
public void createCustomer() throws InterruptedException
{
	
	loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
	homepage.endTourButtonClick();	
	homepage.clickOnContactsButton();
	homepage.clickOnCustomersButton();
	customerpage.addCustomerBtn().click();
	String name=Fakerutility.getFakeFirstName();
	int mobileno=Fakerutility.getRandomNumber();
	int contactid=Fakerutility.getRandomNumber();
	customerpage.addCustomer(name, mobileno, contactid);
	Thread.sleep(3000);
	customerpage.searchCustomer(name);
	Thread.sleep(3000);
	Assert.assertEquals(customerpage.customerNameFinder(), name);
}
}
