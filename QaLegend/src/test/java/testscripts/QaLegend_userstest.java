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

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class QaLegend_userstest extends Baseclass


{
	WebDriver driver;
	QaLegendLoginPage loginpage;
	QaLegendHomePage homepage;
	QaLegendUserPage userpage;

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
		userpage=new QaLegendUserPage(driver);
		
		
		
}
	@Test
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
	@Test
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
@Test
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


