package Utilities;//used for generic methods like click,drag etc
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Pageutilities {
	//Generic methods
	WebDriver driver;
	//click an element if selenium hange the click
	public static void ClickOnAnElement(WebElement element)
	{
		element.click();
	
	}
	//handle drop element by select class
	public static void SelectByValue(WebElement element,String Value)
	{
		Select select=new Select(element);
		select.selectByValue(Value);
	}
public static void SelectByVisibleText(WebElement element,String text)
{
	Select select=new Select(element);
	select.selectByVisibleText(text);
}
public static void SelectbyIndex(WebElement element,int index)
{
	Select select=new Select(element);
	select.selectByIndex(index);
}
public static void dragAndDrop(WebElement source,WebElement destination,WebDriver driver)
{
	Actions action =new Actions(driver);
	action.dragAndDrop(source, destination).build().perform();
		
}
public static void rightClickOnAnElement(WebElement element,WebDriver driver)
{
	Actions action =new Actions(driver);
	action.contextClick(element).build().perform();
		
}
public static void rightClick(WebElement element,WebDriver driver)
{
	Actions action =new Actions(driver);
	action.contextClick(element).build().perform();
		
}
public static void mouseOver(WebElement element,WebDriver driver)
{
	Actions action =new Actions(driver);
	action.moveToElement(element).build().perform();
		
}
public static void clickUsingJavaScriptExecutor(WebElement element,WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
}
public static void scrollTillElementVisible(WebElement element,WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();",element);
}
public static boolean isElementVisible(WebElement element)
{
	return(element.isDisplayed());
}
public static boolean isElementEnable(WebElement element)
{
	return(element.isEnabled());
}
public static String getElementText(WebElement element)//no need to pass string
{
	String value=element.getText();//return(element.getText());
	return(value);
	
}
public static String getElementAttribute(WebElement element,String attributeName)
{
	return(element.getAttribute(attributeName));
}
public static void navigateTo(WebDriver driver,String url)
{
	driver.navigate().to(url);
}
public static void navigateBack(WebDriver driver)
{
	driver.navigate().back();
	
}
public static void navigateForward(WebDriver driver)
{
	driver.navigate().forward();
}
public static void refreshPage(WebDriver driver)
{
	driver.navigate().refresh();
}
public static void acceptAlert(WebDriver driver)
{
	Alert alert=driver.switchTo().alert();
	alert.accept();
	
}
public static void dismissAlert(WebDriver driver)
{
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
	
}

public static void clickOnAnElement(WebElement element) {
	
	element.click();
}
public static String getText(WebElement element) {
	return(element.getText());
}
public static void clearText(WebElement element)
{
	element.clear();
}
public static void enterText(WebElement element, String value) {
	element.sendKeys(value);
}
}

