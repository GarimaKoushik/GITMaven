package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

		@FindBy(xpath="//div[text()='Login']")
		WebElement divLogin;
		
		@FindBy(xpath="//input[@name='username']")
		WebElement txtUserName;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement txtPassword;		
		
		@FindBy(xpath="//button[text()='Login']")
		WebElement btnLogin;
		
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public boolean validateLoginPage()
		{
			
			return divLogin.isDisplayed();
		}
		
		public WelcomePage login(String usrname, String password)
		{
			txtUserName.sendKeys(usrname);
			txtPassword.sendKeys(password);;
			btnLogin.click();
			return new WelcomePage();
		}
	
}
