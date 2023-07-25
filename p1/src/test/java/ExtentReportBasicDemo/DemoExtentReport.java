
package ExtentReportBasicDemo;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoExtentReport {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
	WebDriver driver;
	
	@BeforeTest
	public void BrowserLaunch() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
		extent.attachReporter(spark);
		System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:3000/");			
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
	@Test
	public void TestCase_001() {
		ExtentTest test = extent.createTest("Verify the page title").assignAuthor("Gauri Kadyan");
		test.info("I am verifying the page title");
		String title = driver.getTitle().toString();
		test.info("Captures page title= "+title);
		if(title.equals("NodeJs")) {
			test.pass("The page title is verified successfully");
		}
		else {
			test.fail("Page title cannot be verified successfully");
		}
	}
	@Test
	public void TestCase_002() {
		ExtentTest test = extent.createTest("Verify adding information ").assignAuthor("Gauri Kadyan");
		try {
			driver.findElement(By.linkText("+ New User")).click();
			WebElement userId;
			userId = driver.findElement(By.id("firstName"));
			userId.sendKeys("Gauri");
			test.info("I am entering the first name ");
			driver.findElement(By.name("lastName")).sendKeys("Kadyan");
			test.info("I am entering the last name");
			driver.findElement(By.name("tel")).sendKeys("9212728735");
			test.info("I am entering telephome number");
			driver.findElement(By.name("email")).sendKeys("gkadyan_be20@thapar.edu");
			test.info("I am entering the email");
			driver.findElement(By.id("details")).sendKeys("COE17");
			test.info("I am entering the details");
			driver.findElement(By.xpath("/html/body/div/div/main/form/div[4]/button")).click();
			test.pass("User has successfully written in  the details");
			test.addScreenCaptureFromPath(capturescreenshot(driver));	
		}
		catch(Exception e) {
			test.fail("Was not able to add details" +e.getMessage());
			test.addScreenCaptureFromPath(capturescreenshot(driver));			
		}
	}
	


	

	public static String capturescreenshot(WebDriver driver) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFilePath = new File("Screenshots/"+System.currentTimeMillis()+".png");
		String absolutePathLocation = destinationFilePath.getAbsolutePath();
		try {
			FileUtils.copyFile(srcFile, destinationFilePath);
		}catch(IOException e){
			e.printStackTrace();
		}
		return absolutePathLocation;
	}
}