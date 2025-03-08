package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;


public class QaLegendRolePage 
{
	WebDriver driver;
	@FindBy (xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addRoleButton;
	@FindBy (id="name")
	WebElement roleNameField;
	@FindBy (xpath="//button[@class='btn btn-primary pull-right']")
	WebElement roleSaveButton;
	@FindBy (xpath="//input[@class='form-control input-sm']")
	WebElement searchRoleTextBox;
	@FindBy (xpath="(//tr[@class='odd' or @class='even'])[1]")
	WebElement roleNameCell;
	@FindBy (xpath="(//button[@class='btn btn-xs btn-danger delete_role_button'])[1]")
	WebElement deleteRoleButton;
	@FindBy (xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deleteConfirmationButton;
	@FindBy (xpath="//td[@class='dataTables_empty']")
	WebElement emptyRoleTable;
	
	public QaLegendRolePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}



	public WebElement addRoleBtn()
	{
		return(addRoleButton);
	}
	
	
	
	public QaLegendRolePage addRole(String rname)
	{
		Pageutilities.enterText(roleNameField, rname);
		Pageutilities.clickOnAnElement(roleSaveButton);
		return this;
	}
	public WebElement saveRoleBtn()
	{
		return(roleSaveButton);
	}
	public void searchRole(String rolename)
	{
		Pageutilities.clearText(searchRoleTextBox);
		searchRoleTextBox.sendKeys(rolename);
	}
	public String roleNameFinder()
	{
		String name=Pageutilities.getText(roleNameCell);
		return name;
	}
	public QaLegendRolePage deleteRole()
	{
		Pageutilities.clickOnAnElement(deleteRoleButton);
		Pageutilities.clickOnAnElement(deleteConfirmationButton);
		return this;
	}
	public String getRoleTableStatus()
	{
		return(Pageutilities.getText(emptyRoleTable));
	}
	
}
