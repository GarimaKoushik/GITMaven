package pageTest;
import pages.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;


public class LoginPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	WelcomePage welcomePage;
	
	@BeforeMethod
	public void initialize()
	{
		initialization();
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();
	}
	
	@Test(priority=1)
	public void validateLoginPageTest()
	{
		boolean isLoginPageDisplayed=loginPage.validateLoginPage();
		Assert.assertTrue(isLoginPageDisplayed);
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		welcomePage=loginPage.login(username, password);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
