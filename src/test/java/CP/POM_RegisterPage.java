package CP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class POM_RegisterPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//*[text()='REGISTER']")
	WebElement RegisterTab;
	
	@FindBy(xpath="//*[@name='firstName']")
    WebElement FNameFailed;
	
	@FindBy (xpath="//*[@name='lastName']")
	WebElement LNameFailed;
	
	@FindBy (xpath="//*[@name='phone']")
	WebElement Phone;
	
	@FindBy (xpath="//*[@name='userName']")
	WebElement Email;
	
	@FindBy (xpath="//*[@name='address1']")
	WebElement address1;
	
	@FindBy (xpath="//*[@name='city']")
	WebElement city;
	
	@FindBy (xpath="//*[@name='state']")
	WebElement state;
	
	@FindBy (xpath="//*[@name='postalCode']")
	WebElement postalCode;
	
	@FindBy (xpath="//*[@name='country']")
	WebElement country;
	
	@FindBy (xpath="//*[@name='email']")
	WebElement UserName;
	
	@FindBy (xpath="//*[@name='password']")
	WebElement password;
	
	@FindBy (xpath="//*[@name='confirmPassword']")
	WebElement confirmPassword;
	
	@FindBy (xpath="//*[@name='submit']")
	WebElement submit;
	
	@FindBy (xpath="//*[contains(text(),' Note: Your user name is ')]")
	WebElement R_C;
	
	@FindBy (xpath="//*[contains(text(),'PAssword and con.password does not match')]")
	WebElement NotMach;
	
	
	public POM_RegisterPage(WebDriver driver) {
		POM_RegisterPage .driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	
	public void RegisterTab() {
		RegisterTab.click();
	}
	
	public void FNameFailed(String FName ) {
		FNameFailed.sendKeys(FName);
	}
	
	public void LNameFailed(String Lname) {
		LNameFailed.sendKeys(Lname);
	}
	
	public void Phone(String Pnumber) {
		Phone.sendKeys(Pnumber);
	}
	
	public void Email(String email) {
		Email.sendKeys(email);
	}
	
	public void address1(String address) {
		address1.sendKeys(address);
	}
	
	public void city(String City) {
		city.sendKeys(City);
	}
	
	public void state(String State) {
		state.sendKeys(State);
	}
	
	public void postalCode(String PostalCode) {
		postalCode.sendKeys(PostalCode);
	}
	//to pass the country value from test class 
	//Capital "Country" is String value
	//Small "country" is webElement
	public void country(String Country) {
    Select s=new Select (country);
    s.selectByValue(Country);
	}
	
	public void UserName(String username) {
		UserName.sendKeys(username);
	}
	
	//to retrieve the user name in the UserName method and reuse with my assertion method  
	public String ReturnUsername() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.attributeToBeNotEmpty(UserName, "value"));
        return UserName.getAttribute("value");
	}
	
	
	public void password(String Pass) {
		password.sendKeys(Pass);
	}
	
	public void confirmPassword(String CPass) {
		confirmPassword.sendKeys(CPass);
	}
	
	public void submit() {
		submit.click();
	}
	

	
	public void S_R_C(String UserName) {
		String Actual=R_C.getText();
        String expected = "Note: Your user name is " +UserName + ".";
        SoftAssert s=new SoftAssert();
        s.assertEquals(Actual, expected);
    	s.assertAll();
    	System.out.println("Registration successes");

	}
	
	public void NotMacchAssert() {
	String Actual=NotMach.getText();
	String expected="PAssword and con.password does not match";
	SoftAssert s=new SoftAssert();
	s.assertEquals(Actual, expected);
	s.assertAll();
	System.out.println("Registration fail, PAssword and con.password does not match");

	
	}

	

}
