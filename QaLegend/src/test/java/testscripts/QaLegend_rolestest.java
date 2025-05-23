package testscripts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendRolePage;
import Utilities.Fakerutility;
import Utilities.RetryAnalyzer;


public class QaLegend_rolestest extends Baseclass
{
	WebDriver driver;
	QaLegendLoginPage loginpage;
	QaLegendHomePage homepage;
	QaLegendRolePage rolepage;
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
		rolepage=new QaLegendRolePage(driver);
		

}
	@Test(retryAnalyzer = RetryAnalyzer.class,priority=8, groups={"smoke"})
	public void createRoleName() throws InterruptedException 
	{
		
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnRolesButton();
		rolepage.addRoleBtn().click();
		String rolename=Fakerutility.getFakeFirstName();
		rolepage.addRole(rolename);
		rolepage.searchRole(rolename);
		Assert.assertEquals(rolepage.roleNameFinder(), rolename);
	}
	@Test(retryAnalyzer = RetryAnalyzer.class,priority=9, groups={"smoke"})
    public void deleteRoleName() throws InterruptedException
    {
	
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnRolesButton();
		rolepage.addRoleBtn().click();
		String rolename=Fakerutility.getFakeFirstName();
		rolepage.addRole(rolename);
		rolepage.searchRole(rolename);
		rolepage.deleteRole();
		rolepage.searchRole(rolename);
		Assert.assertEquals(rolepage.getRoleTableStatus(), "No matching records found");
    }
}
