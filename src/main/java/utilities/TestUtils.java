package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class TestUtils extends TestBase{

	public static void doWait(WebElement elm, int timeInMilliSec)
	{
		WebDriverWait wait =new WebDriverWait(driver,timeInMilliSec);
		wait.until(ExpectedConditions.visibilityOf(elm));
		
	}
	public static void clickUsingJavaScriptExecutor(WebElement elm)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",elm);
	}
	public static void performMouseClick(WebElement elm)
	{
		
		Actions action =new Actions(driver);
		action.moveToElement(elm).click().perform();
	}
	
	public static void scrollWebPageDownTillElement(WebElement elm)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", elm);
	}
	
}
