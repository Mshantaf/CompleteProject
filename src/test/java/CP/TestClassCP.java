package CP;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClassCP extends BaseClassCPTest {
	
	@Test(priority=1,description="registration_with_valid_data passed, reg test",enabled=true,invocationCount=1,groups= {"reg"})
	   @Parameters({"FN", "LN"})
	   public void registration_with_valid_data(String FN , String LN)  {
		   driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		   POM_RegisterPage c=new POM_RegisterPage(driver);
	       c.RegisterTab();	 
	       c.FNameFailed(FN); // "Mohamed"
	     c.LNameFailed(LN); // "elsh"
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
	   
	   @Test(priority=2,enabled=true,invocationCount=1,groups= {"smoke"},description="ReTypeWrongPass passed,smoke test")
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

}
