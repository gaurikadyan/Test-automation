//package MyPageObjects;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.JavascriptExecutor;
//
//
//public class LoginPage {
//	WebDriver ldriver;
//	public LoginPage(WebDriver rdriver){
//		ldriver = rdriver ;
//		PageFactory.initElements(rdriver, this);
//		//initialize all internal dependencies //learn 
//		
//		
//	}
//	@FindBy(linkText="+ New User")
//	WebElement txtNewUser;
//	
//	@FindBy(xpath="/html/body/div/div/main/form/div[4]/button")
//	WebElement addCustomer;
//
//
//	@FindBy(id = "firstName")
//	WebElement txtUserName;
//	
//	@FindBy(name = "lastName")
//	WebElement lst;
//	
//	@FindBy(name = "tel")
//	WebElement tele;
//	
//	@FindBy(name = "email")
//	WebElement ema;
//	
//	@FindBy(id = "details")
//	WebElement det;
//	
//	
//	
//
//	// Cast the driver to JavascriptExecutor
//	JavascriptExecutor js = (JavascriptExecutor)driver ;
//
//	
//
//	// Scroll to the element using JavascriptExecutor
//	js.executeScript("arguments[0].scrollIntoView(true);", addCustomer);
//
//
//	
//	
//	public void clickNewUser() 
//	{
//		txtNewUser.click();
//	}
//	public void setUserName(String uname) 
//	{
//		txtUserName.sendKeys(uname);
//	}
//	
//	public void setlastname(String pwd)
//	{
//		lst.sendKeys(pwd);
//	}
//	
//	public void settelephone(String t) {
//		tele.sendKeys(t);
//	}
//	
//	public void setemail(String em) {
//		ema.sendKeys(em);
//	}
//	
//	public void setdetails(String d) {
//		det.sendKeys(d);
//	}
//	
//	
//	
//
//	
//	public void addNewCustomer() {
//		
//		
//		addCustomer.click();
//	}
//	
//	
//	
//	
//
//}

package MyPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage {
	WebDriver ldriver;
	JavascriptExecutor js;

	@FindBy(linkText="+ New User")
	WebElement txtNewUser;
	
	@FindBy(xpath="/html/body/div/div/main/form/div[4]/button")
	WebElement addCustomer;

	@FindBy(id = "firstName")
	WebElement txtUserName;
	
	@FindBy(name = "lastName")
	WebElement lst;
	
	@FindBy(name = "tel")
	WebElement tele;
	
	@FindBy(name = "email")
	WebElement ema;
	
	@FindBy(id = "details")
	WebElement det;

	public LoginPage(WebDriver rdriver){
		ldriver = rdriver ;
		PageFactory.initElements(rdriver, this);
		js = (JavascriptExecutor) rdriver;
	}
	
	public void scrollToAddCustomer() {
		js.executeScript("arguments[0].scrollIntoView(true);", addCustomer);
	}
	
	public void clickNewUser() {
		txtNewUser.click();
	}
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setlastname(String pwd) {
		lst.sendKeys(pwd);
	}
	
	public void settelephone(String t) {
		tele.sendKeys(t);
	}
	
	public void setemail(String em) {
		ema.sendKeys(em);
	}
	
	public void setdetails(String d) {
		det.sendKeys(d);
	}
	
	
	
	public void addNewCustomer() {
		Actions actions = new Actions(ldriver);
		WebElement element = ldriver.findElement(By.xpath("/html/body/div/div/main/form/div[4]/button"));
		
		actions.moveToElement(element).perform();
		addCustomer.click();
	}
}
