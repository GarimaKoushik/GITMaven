package pageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.*;

public class WelcomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	WelcomePage welcomePage;
	
	@BeforeMethod
	public void initialize()
	{
		initialization();
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();
		welcomePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void validateUserLogoTest()
	{
		boolean isLogoDisplayed=welcomePage.validateUserLogo();
		Assert.assertTrue(isLogoDisplayed);
	}
	
	@Test
	public void searchHotelTest()
	{
		welcomePage.searchHotel();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
