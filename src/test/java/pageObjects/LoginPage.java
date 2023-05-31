package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
			WebDriver driver;
			public LoginPage(WebDriver driver) 
			{
				this.driver=driver;
				PageFactory.initElements(driver,this);
				
			}
			//we Can use either Constructor or method to initalize driver object to variables
//			public void LoginPageMethod(WebDriver driver)
//			{
//				this.driver=driver;
//				PageFactory.initElements(driver,this);
//			}
	
	void sum()
	{
		driver.get("");
	}
	
	
	//pageObjects
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement click_login;
	
	@FindBy(name="Username")
	WebElement username_txt;
	
	@FindBy(name="Password")
	WebElement password_txt;
	
	@FindBy(name="login")
	WebElement login_btn;
	
    @FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement click_logout;
    
    @FindBy(xpath="//h1[normalize-space()='Dashboard']")
    WebElement succes_ele;
	
	  
	//actionMethods
	public void clickLogin()
	{
		click_login.click();
	}
	public void setUsername(String uname)
	{
		username_txt.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		password_txt.sendKeys(pwd);
	}
	
	public void ClickLoginButton()
	{
		login_btn.click();
	}
	
   public void clickLogout()
	{
		click_logout.click();
	}
	
	public boolean VerifysucessMsg()
	{
		try
		{
			return(succes_ele.isDisplayed());
			
		}
		catch(Exception e)
		{
			return(false);
			
		}
	}
	
	
	
	
	
	
	
	

}
