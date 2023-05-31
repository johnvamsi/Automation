package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.Automation_BaseClass;

public class TC__002__Login extends Automation_BaseClass {
	
	
	@Test(groups= {"sanity"})
	public void Test__Login() throws InterruptedException
	{
		logger.info("## TestCase is   Started ##");
		try 
		{
				LoginPage lp = new LoginPage(driver);
				//lp.LoginPageMethod(driver);
				lp.clickLogin();
				logger.info("Clicked on login");
				lp.setUsername(rb.getString("userName"));
				logger.info("Username is entered");
				lp.setPassword(rb.getString("Password"));
				logger.info("password is entered");
				lp.ClickLoginButton();
				logger.info("Button is clicked");
				Thread.sleep(5000);
			  boolean bb=	lp.VerifysucessMsg();
			  if(bb==true)
			  {
				  System.out.println("Test Passed");
				  logger.info("Captured sucess message");
				  Assert.assertTrue(true);
				
			  }
			  else
			  {
				  System.out.println("Test failed");
				  logger.info("NOT Captured sucess message");
				  captureScreen("LoginTest");
				  Assert.assertTrue(false);
			  }
				lp.clickLogout();
				 logger.info("Clicked on logout");
		}
		catch(Exception e)
		{
			 logger.info("Failed testcase");
			Assert.fail();
		}
		logger.info("***  TestCase is   Executed  ***");
		
	}
	
	
}
