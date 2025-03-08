package testscripts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendSalesCommissionAgentPage;
import PageClasses.QaLegendSupplierPage;
import PageClasses.QaLegendUserPage;
import Utilities.Fakerutility;

public class QaLegend_salescommissionagentstest extends Baseclass
{
	WebDriver driver;
	QaLegendLoginPage loginpage;
	QaLegendHomePage homepage;
	QaLegendSalesCommissionAgentPage salescommissionagentpage;
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
		salescommissionagentpage=new QaLegendSalesCommissionAgentPage(driver);
		
	}
	
	@Test
	public void createSalesCommissionAgents() throws InterruptedException
	{
		
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnSalesCommissionAgentsButton();
		salescommissionagentpage.addSCAgentButton().click();
		String SCName= Fakerutility.getFakeFirstName();
		int SCPercentage= 25;
		salescommissionagentpage.addSCAgent(SCName, SCPercentage);
		salescommissionagentpage.searchSCAgent(SCName);
		Assert.assertEquals(salescommissionagentpage.SCNameFinder(), SCName);
		
	}
	@Test
	public void deleteSalesCommissionAgents() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homepage.clickOnSalesCommissionAgentsButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		salescommissionagentpage.addSCAgentButton().click();
		String SCName= Fakerutility.getFakeFirstName();
		int SCPercentage= 25;
		salescommissionagentpage.addSCAgent(SCName, SCPercentage);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		salescommissionagentpage.searchSCAgent(SCName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		salescommissionagentpage.deleteSCAgent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		salescommissionagentpage.searchSCAgent(SCName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(salescommissionagentpage.getSCAgentTableStatus(), "No matching records found");
	}	
		

}
