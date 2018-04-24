package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage {
	
	@FindBy(xpath="//input[@name='checkin']")
	WebElement txtCheckIn;
	
	

}
