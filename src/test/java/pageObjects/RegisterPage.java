package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
     WebDriver driver;
     public RegisterPage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
    	 
     }
     
     //pageObjects
     @FindBy(xpath="//a[normalize-space()='Sign Up']")
     WebElement signup_btn;
     
     @FindBy(name="FirstName")
     WebElement firstname_txt;
     
     @FindBy(xpath="//input[@id='Surname']")
     WebElement surname_txt;
     
     @FindBy(id="E_post")
     WebElement post_txt;
     
     @FindBy(name="Mobile")
     WebElement mobile_txt;
     
     @FindBy(name="Username")
     WebElement username_txt;
     
     @FindBy(name="Password")
     WebElement password_txt;
     
     @FindBy(name="ConfirmPassword")
     WebElement Cnfpassword_txt;
     
     @FindBy(id="submit")
     WebElement click_submit;
     
     @FindBy(xpath="//label[normalize-space()='Registration Successful']")
     WebElement success_msg;
     
     
     //actionMethods
     public void clickSignup()
     {
    	 signup_btn.click();
     }
     public void setFirstName(String fname)
     {
    	 firstname_txt.sendKeys(fname);
     }
     public void setSurName(String sname)
    {
    	 surname_txt.sendKeys(sname);
    }
     public void setPost(String post)
     {
    	 post_txt.sendKeys(post);
     }
     public void setMobileNumber(String numb)
     {
    	 mobile_txt.sendKeys(numb);
     }
     public void setUsername(String un)
     {
    	 username_txt.sendKeys(un);
     }
     public void setPassword(String pwd)
     {
    	 password_txt.sendKeys(pwd);
     }
     public void setConfirmPassword(String cnfpwd)
     {
    	 Cnfpassword_txt.sendKeys(cnfpwd);
     }
     public void clickSubmit()
     {
    	 click_submit.click();
     }
     public boolean getSucessMsg()
     {
    	 try
    	 {
    		 return(success_msg.isDisplayed());
    	 }
    	 catch(Exception e)
    	 {
    		 return(false);
    	 }
     }
     
     
     
}
