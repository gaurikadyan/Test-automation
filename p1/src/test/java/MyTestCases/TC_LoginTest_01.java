package MyTestCases;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import MyPageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass {
	
	@Test
	public void Enterdetails() throws InterruptedException {
		Logger logger;
		logger = LogManager.getLogger(TC_LoginTest_01.class);
		
		//PropertyConfigurator.cofigure("Log4j.properties");
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.clickNewUser();
		lp.setUserName(username);
		logger.info("First name entered successfully ");
		lp.setlastname(lastname);
		logger.info("lastname is successfully entered");
		lp.settelephone(telephone);
		logger.info("telephone is successfully entered");
		lp.setemail(email);
		logger.info("email is successfully entered");
		lp.setdetails(details);
		logger.info("details are successfully entered");
		
		lp.addNewCustomer();
		logger.info("New Customer successfully added");
		
		
		//driver.wait(1000);
		
//		driver.get(baseURL);
//		LoginPage lp = new LoginPage(driver);
//		lp.setUserName(username);
//		lp.setPassword(password);
//		lp.clickSubmit();
		
		if(driver.getTitle().equals("NodeJs")) {
			Assert.assertTrue(true);
			logger.info("Log in was successful");
			
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Log in was not successful");
			
		}
	}

}
