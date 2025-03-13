package PageClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Pageutilities;
import Utilities.Waitutilities;

public class QaLegendSalesCommissionAgentPage 
{
	WebDriver driver;
	@FindBy (xpath="//button[@class='btn btn-primary btn-modal pull-right']")
	WebElement addSCAgentsButton;
	@FindBy (xpath="//input[@id='first_name']")
	WebElement firstNameSCAgents;
	@FindBy (id="cmmsn_percent")
	WebElement SCPercentage;
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement saveSCAgentsButton;
	@FindBy (xpath="//input[@class='form-control input-sm']")
	WebElement searchSCAgentTextBox;
	@FindBy (xpath="//button[@class='btn btn-xs btn-danger delete_commsn_agnt_button']")
	WebElement SCAgentDeleteButton;
	@FindBy (xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deleteConfirmationButton;
	@FindBy (xpath="(//tr[@class='odd' or @class='even']//td)[1]")
	WebElement SCNameCell;
	@FindBy (xpath="//td[@class='dataTables_empty']")
	WebElement emptySCAgentTable;
	
	public QaLegendSalesCommissionAgentPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	public WebElement addSCAgentButton()
	{
		return(addSCAgentsButton);
	}
	
	
	public QaLegendSalesCommissionAgentPage addSCAgent(String SCAgentFname, int SCAgentPercentage)
	{
		Pageutilities.enterText(firstNameSCAgents, SCAgentFname);
		Pageutilities.enterText(SCPercentage, Integer.toString(SCAgentPercentage));
		Pageutilities.ClickOnAnElement(saveSCAgentsButton);
		return this;
		
	}
	public void searchSCAgent(String CAName)
	{
		Waitutilities.waitForElementtobeInvisible(driver,searchSCAgentTextBox);
		Pageutilities.clearText(searchSCAgentTextBox);
		searchSCAgentTextBox.sendKeys(CAName);
	}
	public QaLegendSalesCommissionAgentPage deleteSCAgent()
	{
		Waitutilities.waitForClickingElement(driver, SCAgentDeleteButton);
		Pageutilities.ClickOnAnElement(SCAgentDeleteButton);
		Pageutilities.ClickOnAnElement(deleteConfirmationButton);
		return this;
	}
	public String SCNameFinder()
	{
		String name=Pageutilities.getText(SCNameCell);
		return name;
	}
	public String getSCAgentTableStatus()
	{
		return (Pageutilities.getText(emptySCAgentTable));
	}

	
	
	
	

}
