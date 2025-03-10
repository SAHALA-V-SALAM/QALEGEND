package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;
import Utilities.Waitutilities;

import org.openqa.selenium.WebElement;

public class QaLegendSupplierPage
{
	WebDriver driver;
	@FindBy (xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addSupplierButton;
	@FindBy (id="name")
	WebElement nameField;
	@FindBy (id="supplier_business_name")
	WebElement businessNameField;
	@FindBy (id="mobile")
	WebElement mobilenumberField;
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement saveButton;
	@FindBy (xpath="//input[@class='form-control input-sm']")
	WebElement searchSupplierTextBox;
	@FindBy (xpath="(//tr[@class='odd' or @class='even']//td)[3]")
	WebElement supplierNameCell;
	@FindBy (xpath="//button[@class='btn btn-info dropdown-toggle btn-xs']")
	WebElement actionButton;
	@FindBy (xpath="(//a[@class='delete_contact_button'])[1]")
	WebElement supplierDeleteButton;
	@FindBy (xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deleteConfirmationButton;
	@FindBy (xpath="td[@class='dataTables_empty']")
	WebElement emptySupTable;
	
	
	
	public QaLegendSupplierPage (WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement addSupplierBtn()
	{
		return(addSupplierButton);
	}
	public QaLegendSupplierPage addSupplier(String sprname,String sprbusinessname,String sprmobilenumber)
	{
		Pageutilities.enterText(nameField, sprname);
		Pageutilities.enterText(businessNameField, sprbusinessname);
		Pageutilities.enterText(mobilenumberField, sprmobilenumber);
		Pageutilities.clickOnAnElement(saveButton);
		return this;
	}
	public void searchSupplier(	String suppliername)
	{
		Waitutilities.waitForElementtobeInvisible(driver, searchSupplierTextBox);
		Pageutilities.clearText(searchSupplierTextBox);
		searchSupplierTextBox.sendKeys(suppliername);
		
	}
	public String supplierNameFinder()
	{
		String name=Pageutilities.getText(supplierNameCell);
		return name;
	}
	public QaLegendSupplierPage deleteSupplier()
		{
		Pageutilities.ClickOnAnElement(supplierDeleteButton);
		Pageutilities.ClickOnAnElement(deleteConfirmationButton);
		return this;
		}
	public void actionBtn()
	{
		Waitutilities.waitForClickingElement(driver, actionButton);
		Pageutilities.clickOnAnElement(actionButton);
		
	}
	public String getSupplierTableStatus()
	{
		return (Pageutilities.getText(emptySupTable));
	}
	}
		
	 
