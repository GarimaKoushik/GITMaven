package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utilities.TestUtils;

public class SearchHotelPage extends TestBase{

	
	@FindBy(xpath="//a//span[text()='View Map']")
	WebElement lnkViewMap;
	
	@FindBy(xpath="//button[@id='searchform']")
	WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='itemscontainer']//table")
	WebElement tblHotels;
	
	@FindBy(xpath="//div[@class='offset-3 offset-RTL']/ul/li[4]")
	WebElement nextArrow;
	
	
	public SearchHotelPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//	public boolean validateSearchPage()
//	{
//		return lnkViewMap.isDisplayed();
//	}
//	
	public boolean  searchForResultPage()
	{
		//btnSearch.click();
		return tblHotels.isDisplayed();
		
	}
	
	public DetailsPage selectHotel()
	{
			int bestRating=0;
			int bestPrice=0;
			int bestHotelRow=0;
			int rowCount=tblHotels.findElements(By.tagName("tr")).size();
			for(int rowNum=1;rowNum<=rowCount;rowNum++)
			{
//				int rating =0;
//				int price =0;
				WebElement activeRow=tblHotels.findElement(By.xpath("//tbody/tr[" + rowNum + "]"));
				TestUtils.scrollWebPageDownTillElement(activeRow);
				int rating=tblHotels.findElements(By.xpath("//tbody/tr[" + rowNum + "]/td//span/i[@class='star star icon-star-5']")).size();
				String priceText=tblHotels.findElement(By.xpath("//tbody/tr[" + rowNum +"]/td//b/small[text()='USD']//parent::b")).getText();
				String temp=priceText.replace("USD $","");
				
				int price=Integer.parseInt(temp);
				if(rowNum>1)
				{
					if((rating>bestRating && price<=bestPrice) || (rating>=bestRating && price<bestPrice))
					{

						bestRating=rating;
						bestPrice=price;
						bestHotelRow=rowNum;
						
					}
				}
				else
				{
					bestRating=rating;
					bestPrice=price;
					bestHotelRow=rowNum;
				}
				
			}
			

			tblHotels.findElement(By.xpath("//tbody/tr[" + bestHotelRow + "]//button[text()='Details']")).click();
		
		
		return new DetailsPage();
	}
	
}
