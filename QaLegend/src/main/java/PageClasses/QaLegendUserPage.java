package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;

public class QaLegendUserPage
{
	
	WebDriver driver;
	@FindBy (xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addUserButton;
	@FindBy (id="first_name")
	WebElement firstNameField;
	@FindBy (id="email")
	WebElement emailField;
	@FindBy (id="password")
	WebElement passwordField;
	@FindBy (id="confirm_password")
	WebElement cofirmPasswordField;
	@FindBy (id="submit_user_button")
	WebElement saveButton;
	@FindBy (xpath="//input[@class='form-control input-sm']")
	WebElement searchUserTextBox;
	@FindBy (xpath="(//tr[@class='odd' or @class='even']//td)[2]")
	WebElement nameCell;
	@FindBy (xpath="//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement userDeleteButton;
	@FindBy (xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deleteConfirmationButton;
	@FindBy (xpath="//td[@class='dataTables_empty']")
	WebElement dataTableEmpty;
	@FindBy (xpath="(//a[@class='btn btn-xs btn-primary'])[1]")
	WebElement editUserButton;
	
	
	

	public QaLegendUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement addUserBtn() 
	{
		return(addUserButton);
	}
	public QaLegendUserPage addUser(String fname, String mail, String pword)
	{
		Pageutilities.enterText(firstNameField, fname);
		Pageutilities.enterText(emailField, mail);
		Pageutilities.enterText(passwordField, pword);
		Pageutilities.enterText(cofirmPasswordField, pword);
		Pageutilities.ClickOnAnElement(saveButton);
		
		return this;
	}
	public void searchUser(String username)
	{
		Pageutilities.clearText(searchUserTextBox);
		searchUserTextBox.sendKeys(username);
	}
	public String userNameFinder()
	{
		String name=Pageutilities.getText(nameCell);
		return name;
	}
	public QaLegendUserPage deleteUser()
	{
	Pageutilities.ClickOnAnElement(userDeleteButton);
	Pageutilities.ClickOnAnElement(deleteConfirmationButton);
	return this;
	}
	public String getTableStatus()
	{
		return (Pageutilities.getText(dataTableEmpty));
	}
	public void editUserFirstName(String firstname)
	{
		Pageutilities.ClickOnAnElement(editUserButton);
		Pageutilities.clearText(firstNameField);
		Pageutilities.enterText(firstNameField, firstname);
		Pageutilities.ClickOnAnElement(saveButton);
	}
	public String firstNamevalueFinder()
	{
		return(Pageutilities.getText(nameCell));
		
	}
	
	

}

