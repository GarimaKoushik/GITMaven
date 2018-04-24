package pageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DetailsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.WelcomePage;

public class SearchHotelPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	WelcomePage welcomePage;
	SearchHotelPage searchHotelPage;
	DetailsPage detailsPage;
	
	
	@BeforeMethod
	public void  initialize()
	{
		initialization();
		homePage=new HomePage();
		loginPage=homePage.clickOnLoginLink();
		welcomePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchHotelPage=welcomePage.searchHotel();
	
	}
//	@Test(priority=1)
//	public void validateSearchPageTest()
//	{
//		boolean isSearchPageDisplayed=searchHotelPage.validateSearchPage();
//		Assert.assertTrue(isSearchPageDisplayed);
//	}
	
	@Test(priority=1)
	public void searchForReasultTest()
	{
		boolean isResultTableDisplayed=searchHotelPage.searchForResultPage();
		Assert.assertTrue(isResultTableDisplayed);
	}
	
	@Test(priority=2)
	public void selectHotelTest()
	{

		searchHotelPage.selectHotel();
	}
	
	
@AfterMethod
public void tearDown()
{
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}

}
