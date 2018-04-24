package pages;
import utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class WelcomePage extends TestBase{
	
	@FindBy(xpath="//img[contains(@src,'default/user.png')]")
	WebElement imgUserLogo;
	
	@FindBy(xpath="//a[@href='https://www.phptravels.net/hotels' or @title='Hotels']")
	WebElement imgHotelLogo;
	
	
public WelcomePage()
  {
	PageFactory.initElements(driver, this);
  }

public boolean validateUserLogo()
{
	return imgUserLogo.isDisplayed();
}

public SearchHotelPage searchHotel()
{
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	TestUtils.doWait(imgHotelLogo, 10);
	//TestUtils.clickUsingJavaScriptExecutor(imgHotelLogo);
	//imgHotelLogo.click();
	TestUtils.performMouseClick(imgHotelLogo);
	//driver.get("https://www.phptravels.net/hotels");
	return new SearchHotelPage();
}


}