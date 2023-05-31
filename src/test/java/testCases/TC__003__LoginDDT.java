package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.Automation_BaseClass;
import utilities.XLUtils;

public class TC__003__LoginDDT extends Automation_BaseClass {
	
	 String xlpath="C:\\Users\\HP\\Documents\\AutomationTestData.xlsx";
	
	@Test(dataProvider="LoginDDT" ,groups= {"regression"})
	public void Test__LoginDDT(String username,String Password,String status) throws InterruptedException, IOException
	{
				LoginPage lp = new LoginPage(driver);
				lp.clickLogin();
				lp.setUsername(username);
				lp.setPassword(Password);
				lp.ClickLoginButton();
				Thread.sleep(5000);
	  boolean targetPage=	lp.VerifysucessMsg();
	  
	  if(status.equals("Valid"))
	  {
				  if(targetPage==true)
				  {
					  lp.clickLogout();
					  Assert.assertTrue(true);
					 
					  
				  }
				  else
				  {
					  CaptureScreen(driver,"LoginDDT");
					  Assert.assertTrue(false);
				  
				  }
	  }
	  if(status.equals("Invalid"))
	  {
				  if(targetPage==true)
				  {
					  CaptureScreen(driver,"LoginDDT");
					  lp.clickLogout();
					  Assert.assertTrue(false);
					  
				  }
				  else
				  {
					  Assert.assertTrue(true);
					 
				  }
		  
	  }
	  driver.navigate().refresh();
	  
}	  
	  @DataProvider(name="LoginDDT")
	  public String[][] get_LoginData() throws IOException
	  {
		  String xlpath="C:\\Users\\HP\\Documents\\AutomationTestData.xlsx";
		 int rowCount=XLUtils.getRowCount(xlpath, "LoginDDT");
		 int colCount=XLUtils.getCellCount(xlpath, "LoginDDT", 1);
		 
		 String[][] loginDDT= new String[rowCount][colCount];
		 
		 for(int r=1;r<=rowCount;r++)
		 {
			 for(int c=0;c<colCount;c++)
			 {
				 loginDDT[r-1][c]=XLUtils.getCellData(xlpath, "LoginDDT", r, c);
			 }
		 }
		  
		 return loginDDT;
	  }
	  
	  

}
