package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;

public class QaLegendHomePage
{
	
	WebDriver driver;
	@FindBy (xpath="//span[text()='User Management']")
	WebElement userManagementButton;
	@FindBy (xpath="//i[@class='fa fa-user']//following-sibling::span")
	WebElement userButton;
	@FindBy (xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endTourButton;
	@FindBy (xpath="//i[@class='fa fa-handshake-o']//following-sibling::span")
	WebElement salesCommissionAgentsButton;
	@FindBy (xpath="(//a[@id='tour_step4_menu']//following-sibling::span)[1]")
	WebElement contactsButton;
    @FindBy (xpath="(//i[@class='fa fa-star']//preceding::a)[14]")
    WebElement suppliersButton;
    @FindBy (xpath="//i[@class='fa fa-briefcase']//following-sibling::span")
	WebElement rolesButton;
    @FindBy (xpath="(//ul[@class='treeview-menu menu-open']//following::a)[2]")
    WebElement customersButton;


	
	
	public QaLegendHomePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	public void clickOnUserManagementButton()
	{
		Pageutilities.ClickOnAnElement(userManagementButton);//pageutilities method
	}
	public void clickOnUserButton()
	{
	    userButton.click();//normal method; click by page class
	}
	public void endTourButtonClick()
	{
		try {
			endTourButton.click();
		}
		catch(Exception e)
		{
			System.out.println("endtour button is not visible");
		}
	}
	public void clickOnSalesCommissionAgentsButton()
	{
		Pageutilities.ClickOnAnElement(salesCommissionAgentsButton);
		
	}
	public void clickOnContactsButton() {
		Pageutilities.ClickOnAnElement(contactsButton);
	
	}
	public void clickOnSuppliersButton()
	{
		Pageutilities.ClickOnAnElement(suppliersButton);
	}
	public void clickOnRolesButton()
	{
		Pageutilities.clickOnAnElement(rolesButton);
	}
	public void clickOnCustomersButton()
	{
		Pageutilities.clickOnAnElement(customersButton);
	}
}
