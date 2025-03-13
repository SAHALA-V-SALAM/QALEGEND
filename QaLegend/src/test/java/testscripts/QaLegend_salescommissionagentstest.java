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
import PageClasses.QaLegendSalesCommissionAgentPage;
import PageClasses.QaLegendSupplierPage;
import PageClasses.QaLegendUserPage;
import Utilities.Fakerutility;
import Utilities.retryAnalyzer;

public class QaLegend_salescommissionagentstest extends Baseclass
{
	WebDriver driver;
	QaLegendLoginPage loginpage;
	QaLegendHomePage homepage;
	QaLegendSalesCommissionAgentPage salescommissionagentpage;
	Properties prop;
	FileInputStream fis;
	@BeforeMethod
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
		salescommissionagentpage=new QaLegendSalesCommissionAgentPage(driver);
		
	}
	
	@Test(retryAnalyzer = retryAnalyzer.class,priority=6)
	public void createSalesCommissionAgents() throws InterruptedException
	{
		
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnSalesCommissionAgentsButton();
		salescommissionagentpage.addSCAgentButton().click();
		String SCName= Fakerutility.getFakeFirstName();
		int SCPercentage= Fakerutility.getRandomNumber();
		salescommissionagentpage.addSCAgent(SCName, SCPercentage);
		salescommissionagentpage.searchSCAgent(SCName);
		Assert.assertEquals(salescommissionagentpage.SCNameFinder(), SCName);
		
	}
	@Test(retryAnalyzer=retryAnalyzer.class,priority=7)
	public void deleteSalesCommissionAgents() throws InterruptedException
	{
		
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();
		homepage.clickOnUserManagementButton();
		homepage.clickOnSalesCommissionAgentsButton();
		salescommissionagentpage.addSCAgentButton().click();
		String SCName= Fakerutility.getFakeFirstName();
		int SCPercentage=Fakerutility.getRandomNumber();
		salescommissionagentpage.addSCAgent(SCName, SCPercentage);
		salescommissionagentpage.searchSCAgent(SCName);
		salescommissionagentpage.deleteSCAgent();
		salescommissionagentpage.searchSCAgent(SCName);
		Assert.assertEquals(salescommissionagentpage.getSCAgentTableStatus(), "No matching records found");
	}	
		

}
