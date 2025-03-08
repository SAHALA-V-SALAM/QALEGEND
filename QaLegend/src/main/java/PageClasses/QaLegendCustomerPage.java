package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;

public class QaLegendCustomerPage
{
	WebDriver driver;
	@FindBy (xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addCustomerButton;
	@FindBy (id="name")
	WebElement customerNameField;
	@FindBy (id="mobile")
	WebElement customerMobileNumberField;
	@FindBy (id="contact_id")
	WebElement customerContactIDField;
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement customerSaveButton;
	@FindBy (xpath="//input[@class='form-control input-sm']")
	WebElement searchCustomerTextBox;
	@FindBy (xpath="(//tr[@class='odd' or @class='even']//td)[2]")
	WebElement customerNameCell;
	
	
	
	public QaLegendCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement addCustomerBtn()
	{
		return(addCustomerButton);
	}

	public QaLegendCustomerPage addCustomer(String ctmrname, int ctmrmobnumber, int ctmrcontactid)
	{
		Pageutilities.enterText(customerNameField, ctmrname);
		Pageutilities.enterText(customerMobileNumberField, Integer.toString(ctmrmobnumber));
		Pageutilities.enterText(customerContactIDField, Integer.toString(ctmrcontactid));
		Pageutilities.clickOnAnElement(customerSaveButton);
		return this;
	}
	public void searchCustomer(String customername)
	
	{
		Pageutilities.clearText(searchCustomerTextBox);
		searchCustomerTextBox.sendKeys(customername);
	}
	public String customerNameFinder()
	{
		String name=Pageutilities.getText(customerNameCell);
		return name;
		
	}
}
