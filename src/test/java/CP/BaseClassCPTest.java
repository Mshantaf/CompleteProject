package CP;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class BaseClassCPTest {
	public WebDriver driver;
	
  @BeforeMethod(alwaysRun=true)
  @Parameters({"brow"})
  public void beforeMethod(String brow) {
  String browser= brow;
  if (browser.contains("Chrome"))
  {	  
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\mshan\\git\\repository6\\2023_batch_bootcamp\\drivers\\chromedriver.exe");
  driver= new ChromeDriver();   
  }
  else if (browser.contains("edge"))
  {
  System.setProperty("webdriver.edge.driver", "C:\\Users\\mshan\\git\\repository6\\2023_batch_bootcamp\\drivers\\msedgedriver.exe");
  driver= new EdgeDriver();   
  }
  else if (browser.contains("Firefox")) 
  {
  System.setProperty("webdriver.gecko.driver", "C:\\Users\\mshan\\git\\repository6\\2023_batch_bootcamp\\drivers\\geckodriver.exe");  
  driver= new FirefoxDriver();   
  }
  driver.get("https://demo.guru99.com/test/newtours/#google_vignette");
  driver.manage().window().maximize();
  }
  
   

   @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	   driver.close();
  }

}
