package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import testBase.Automation_BaseClass;

public class TC__001__Registration extends Automation_BaseClass{
	
	
	@Test(groups= {"sanity"})
	public void Test__Registration() throws InterruptedException
	{
		RegisterPage rp = new RegisterPage(driver);
		rp.clickSignup();
		rp.setFirstName(randomString(10));
		rp.setSurName(randomString(10));
		rp.setPost("12344");
		rp.setMobileNumber("1234566890");
		rp.setUsername(randomString(8));
		rp.setPassword("Test@1234");
		rp.setConfirmPassword("Test@1234");
		rp.clickSubmit();
		Thread.sleep(5000);
	    boolean bb=	rp.getSucessMsg();
		if(bb==true)
		{
			System.out.println("Test Case got passed");
			Assert.assertTrue(true);
		}
		else
		{	
			System.out.println("Test Case got Failed");
		   Assert.assertTrue(false);
			
		}
	}

}
