package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Constants.Constants;
import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendSupplierPage;
import Utilities.ExcelUtilities;
import Utilities.Fakerutility;
import Utilities.RetryAnalyzer;



public class QaLegend_supplierstest extends Baseclass
{
	WebDriver driver;
	QaLegendLoginPage loginpage;
	QaLegendHomePage homepage;
	QaLegendSupplierPage supplierpage;
	Properties prop;
	FileInputStream fis;
	@BeforeMethod(groups= {"smoke","regression"})
	@Parameters("broswer")
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
		supplierpage=new QaLegendSupplierPage(driver);
		

}
	@Test(retryAnalyzer = RetryAnalyzer.class,priority=4)
	
	public void createSupplier() throws InterruptedException, IOException
	{
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();	
		homepage.clickOnContactsButton();
		homepage.clickOnSuppliersButton();
		supplierpage.addSupplierBtn().click();
		String spname=ExcelUtilities.getStringData(1, 0, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
		String spbusinessname=ExcelUtilities.getStringData(1, 1, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
		String spmobilenumber=ExcelUtilities.getIntegerData(1, 2, Constants.EXCELFILEPATH, "Sheet1")+Fakerutility.getRandomNumber();
		supplierpage.addSupplier(spname, spbusinessname, spmobilenumber);
		supplierpage.searchSupplier(spname);
		Assert.assertEquals(supplierpage.supplierNameFinder(), spname);
	}
	@Test(retryAnalyzer = RetryAnalyzer.class,priority=5,groups= {"smoke"})
	public void deleteSupplier() throws InterruptedException
	{
		loginpage.loginToQaLegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.endTourButtonClick();	
		homepage.clickOnContactsButton();
		homepage.clickOnSuppliersButton();
		supplierpage.addSupplierBtn().click();
		String spname=Fakerutility.getFakeFirstName();
		String spbusinessname=Fakerutility.getFakeFirstName();
		String spmobilenumber="9874152430";
		supplierpage.addSupplier(spname, spbusinessname, spmobilenumber);
		supplierpage.searchSupplier(spname);
		supplierpage.actionBtn();
		supplierpage.deleteSupplier();
		supplierpage.searchSupplier(spname);//explicit wait
		Assert.assertEquals(supplierpage.getSupplierTableStatus(), "No matching records found");
		
		
	}
}

