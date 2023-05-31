package testBase;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging

import io.github.bonigarcia.wdm.WebDriverManager;
public class Automation_BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;// to read config.properties
	
	
	@BeforeClass(groups= {"regression","sanity"})
     public void Setup() throws InterruptedException
	{
		rb = ResourceBundle.getBundle("config");// Load config.properties
		logger= LogManager.getLogger(getClass());
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		
       	driver.get(rb.getString("appURL"));//get url from config.properties file
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@AfterClass(groups= {"regression","sanity"})
	public void Tear()
	{
		driver.close();
	}
	
	
	
	//reusableMethods
	public String randomString(int count)
	{
		String generatedString= RandomStringUtils.randomAlphabetic(count);
		return(generatedString);
	}
	public int randomNumber(int count)
	{
		String generatedString1= RandomStringUtils.randomNumeric(count);
		return(Integer.parseInt(generatedString1));
	}
	public String randomAlphaNumeric(int count )
	{
		String generatedString2=RandomStringUtils.randomAlphanumeric(count);
		return(generatedString2);
	}
	
	public void CaptureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		
	}
	
	
	public String captureScreen(String tname) throws IOException 
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

				try 
				{
					FileUtils.copyFile(source, new File(destination));
				} 
				catch (Exception e) 
				{
					e.getMessage();
				}
				return destination;

	}

}
