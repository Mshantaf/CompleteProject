package CP;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class CP_Test {
	public static WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
  System.setProperty("webdriver.chrome.driver","C:\\Users\\mshan\\git\\repository6\\2023_batch_bootcamp\\drivers\\chromedriver.exe");
  driver= new ChromeDriver();
  driver.get("https://demo.guru99.com/test/newtours/#google_vignette");
  driver.manage().window().maximize();
  
  
  }
  
   @Test(priority=1,enabled=true,invocationCount=1)
   public void registration_with_valid_data()  {
	   driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	   POM_RegisterPage c=new POM_RegisterPage(driver);
       c.RegisterTab();	 
       c.FNameFailed("Mohamed");
     c.LNameFailed("elsh");
       c.Phone("4483199");
       c.Email("m.s@hotmail");
       c.address1("47723 TV Street");
       c.city("Broklyn");
       c.state("NY");
       c.postalCode("45525");
       c.country("BAHRAIN");
       c.UserName("M.sh");
       c.password("0123456");
       c.confirmPassword("0123456");
       c.submit();
       c.S_R_C("M.sh");
	   
	  }
   
   @Test(priority=2,enabled=true,invocationCount=1)
   public void ReTypeWrongPass()  {
	   driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	   POM_RegisterPage c=new POM_RegisterPage(driver);
       c.RegisterTab();	 
       c.FNameFailed("Mohamed");
       c.LNameFailed("elsh");
       c.Phone("4483199");
       c.Email("m.s@hotmail");
       c.address1("47723 TV Street");
       c.city("Broklyn");
       c.state("NY");
       c.postalCode("45525");
       c.country("BAHRAIN");
       c.UserName("M.sh");
       c.password("0123456");
       c.confirmPassword("6543210");
       c.submit();
       c.NotMacchAssert();	   
   }

   @AfterMethod
  public void afterMethod() {
	   driver.close();
  }

}
