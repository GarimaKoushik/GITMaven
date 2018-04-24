package pageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	
//public HomePageTest()
//		{
//			super();
//			//System.out.println("SECOND: Hi, i m inside HOMEPageTest Constructor");
//			
//		}
		
		@BeforeMethod
		public void initialize()
		{
			//System.out.println("Third B : I am going to invoke initialization method");
			
			initialization();
			homePage=new HomePage();
			//System.out.println("Hopefully i will be entering into ValidateHomeTitleTest");
		}
		
		@Test(priority=1)
		public void validateHomeTitleTest()
		{
			//System.out.println("I am about validate Home page title");
			String title=homePage.validateHomeTitle();
			Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner");
		}
		
		
		
		@Test(priority=2)
		public void validateHomeLogoTest()
		{
			
			boolean isLogoPresent=homePage.validateHomeLogo();
			Assert.assertTrue(isLogoPresent);
				
			
		}
		@Test(priority=3)
		public void clickOnLoginLinkTest()
		{
			
			loginPage=homePage.clickOnLoginLink();
			
			
		}
		
		@AfterMethod
		public void tearDown()
		{
			
			driver.quit();
		}
		
		
		
		
		
		

}
