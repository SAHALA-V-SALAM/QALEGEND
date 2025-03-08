package Utilities;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constants;

import org.openqa.selenium.WebElement;

public class Waitutilities 
{
public WebDriver driver;
public static void waitForClickingElement(WebDriver driver,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));	
wait.until(ExpectedConditions.elementToBeClickable(element));
}
public static void waitForTextToBePresentTnElement(WebDriver driver,WebElement element,String text)
{
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));	
wait.until(ExpectedConditions.textToBePresentInElement(element, text));
}
public static void waitForElementToBeSelected(WebDriver driver,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));	
wait.until(ExpectedConditions.elementToBeSelected(element));
}
public static void waitForVisibilityOfElement(WebDriver driver,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));	
wait.until(ExpectedConditions.visibilityOf(element));
}
public static void waitForAnAlertToBePresent(WebDriver driver)
{
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));	
wait.until(ExpectedConditions.alertIsPresent());
}
public static void waitForAnElementAttributeToBe(WebDriver driver,WebElement element,String attributename,String attributevalue)
{
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITWAIT));
	wait.until(ExpectedConditions.attributeToBe(element, attributename,attributevalue));
}
public static void waitForElementtobeInvisible(WebDriver driver,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));	
wait.until(ExpectedConditions.invisibilityOf(element));
}

}
