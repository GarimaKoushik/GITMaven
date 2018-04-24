package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static Properties prop;
	public static String browserName;
	public static String url;
	public static String userName;
	public static String password;
	public static WebDriver driver;
	
	
	public TestBase()
	{
		try
		{
			FileInputStream fis =new FileInputStream("D:\\Maven Projects\\PhpTravels\\src\\main\\java\\config\\config.properties");
			prop =new Properties();
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//System.out.println("FIRST: Hi, i m inside TestBase Constructor");
		
		
	}
	
	public static void initialization()
	{
		browserName=prop.getProperty("browser");
		userName=prop.getProperty("username");
		password=prop.getProperty("password");
		url=prop.getProperty("url");
		//System.out.println("fourth : I am inside initialization method");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Automation\\2.Project Selenium\\3. Webdrivers\\Chrome Driver 2.36\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(url);
		}
		
		
	}
	
	
	
	

}
