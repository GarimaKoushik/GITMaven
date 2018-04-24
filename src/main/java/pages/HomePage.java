package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestUtils;
import base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//div[contains(@class,'tbar-bottom hidden-xs')]//a/img[contains(@src,'logo.png')]")
	WebElement imgLogo;
	
	@FindBy(xpath="//div[contains(@class,'tbar-top hidden')]//a[text()=' My Account ']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//div[contains(@class,'tbar-top hidden')]//a[@href='https://www.phptravels.net/login']")
	WebElement lnkLogin;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateHomeTitle()
	{
		
		return driver.getTitle();
				
	}
	
	
	
	public boolean validateHomeLogo()
	{
		//boolean isLogoPresent=false;
		
		
		return imgLogo.isDisplayed();
		
		//return isLogoPresent;
	}
	
	public LoginPage clickOnLoginLink()
	{
		TestUtils.doWait(lnkMyAccount,10);
		//lnkMyAccount.click();
		TestUtils.clickUsingJavaScriptExecutor(lnkMyAccount);
		TestUtils.doWait(lnkLogin,10);
		lnkLogin.click();
		
		return new LoginPage();
	}
	
	

}
