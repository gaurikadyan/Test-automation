package MyTestCases;

import org.openqa.selenium.WebDriver;
import MyUtilities.ReadConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	ReadConfig  readconfig = new ReadConfig();
	//this will be common to all the page objects and may use for different page objects
	public String baseURL = readconfig.getApplicationURL();
	public String username =  readconfig.getUserName();
	public String lastname =  readconfig.getLastName();
	public String telephone =  readconfig.getTelephone();
	public String email =  readconfig.getEmail();
	public String details =  readconfig.getDetails();

	public static WebDriver driver ;
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		driver = new ChromeDriver();
	}
	
//	@AfterClass // execute after compleltion of my test case
//	public void tearDown() {
//		driver.quit();
//	}
	

}
 