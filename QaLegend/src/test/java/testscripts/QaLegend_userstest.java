package testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendSupplierPage;
import PageClasses.QaLegendUserPage;
import Utilities.Fakerutility;
import Utilities.RetryAnalyzer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QaLegend_userstest extends Baseclass


{
	WebDriver driver;
	QaLegendLoginPage loginpage;
	QaLegendHomePage homepage;
	QaLegendUserPage userpage;

	Properties prop;
	FileInputStream fis;
	@BeforeMethod(groups= {"smoke","regression"})
	@Parameters("browser")
	public void browserInitialization(String browsername) throws Exception// camel casing
	{
		driver=initializemethod(browsername);
		prop=new Properties();
		String path= System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\data.properties";//to get dynamic path
		fis=new FileInputStream(path);
		prop.load(fis);//to load property file to prop
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginpage=new QaLegendLoginPage(driver);
		homepage=new QaLegendHomePage(driver);
		userpage=new QaLegendUserPage(driver);
		
		
		
}
	@Test(retryAnalyzer = RetryAnalyzer.class,priority=1,groups= {"regression"})
	public void createaUser() throws InterruptedException
	{
	loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
	
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnUserButton();
	userpage.addUserBtn().click();
	String name=Fakerutility.getFakeFirstName();
	String emailid=name+Fakerutility.getRandomNumber()+"@gmail.com";
	String password="qwertyuiop";
	userpage.addUser(name, emailid, password);
	userpage.searchUser(name);
	Assert.assertEquals(userpage.userNameFinder(), name);
	
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class,priority=2)
public void deleteUser() throws InterruptedException
{
		
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnUserButton();
		userpage.addUserBtn().click();
		String name=Fakerutility.getFakeFirstName();
		String emailid=name+Fakerutility.getRandomNumber()+"@gmail.com";
		String password="qwertyuiop";
		userpage.addUser(name, emailid, password);
		userpage.searchUser(name);
		userpage.deleteUser();
		userpage.searchUser(name);
		Assert.assertEquals(userpage.getTableStatus(), "No matching records found");
		
}
@Test(retryAnalyzer = RetryAnalyzer.class,priority=3)
public void editUser() throws InterruptedException
{
	
	loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
	
	homepage.endTourButtonClick();
	homepage.clickOnUserManagementButton();
	homepage.clickOnUserButton();
	userpage.addUserBtn().click();
	String name=Fakerutility.getFakeFirstName();
	String emailid=name+Fakerutility.getRandomNumber()+"@gmail.com";
	String password="qwertyuiop";
	userpage.addUser(name, emailid, password);
	userpage.searchUser(name);
	String newname=Fakerutility.getFakeFirstName();
	userpage.editUserFirstName(newname);
	userpage.searchUser(newname);
	Assert.assertEquals(userpage.firstNamevalueFinder(), newname);
}

	
}


