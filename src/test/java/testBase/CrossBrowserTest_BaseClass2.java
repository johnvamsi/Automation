package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CrossBrowserTest_BaseClass2 {
	
	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
	@BeforeClass
	@Parameters("browser")
	public void Setup(String br) throws InterruptedException
	{
		rb = ResourceBundle.getBundle("config");// Load config.properties
		logger= LogManager.getLogger(getClass());
		
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else	if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		
		driver.get(rb.getString("appURL"));
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@AfterClass
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

}
