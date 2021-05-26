package makeMyTrip_pageFactory;

import java.util.concurrent.TimeUnit;

import org.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Register extends TestBase{
		
		//WebDriver driver;

		//using @FindBy annotation in PageFactory model
			
		@FindBy (id="username")		//Select input text field for entering values of valid and invalid data
		WebElement emailMobile;
		
		@FindBy (id="otp")			//Select OTP after entering register mobile number
		WebElement regOTP;
		
		@FindBy(xpath = "//button[@class='capText font16']/span")	//Clicks continue and Login
		WebElement continueLogin;
		
		@FindBy (name="verifyOTPText")		//select OTP after entering new mobile number
		WebElement newRegOTP;
		
		@FindBy (id="password")			//select password for register email
		WebElement regEmailPassword;
		
		@FindBy (xpath = "//label[@class='font14 latoBold appendBottom10']")	//Clicks on text for validation text(Email or Mobile Number)
		WebElement validText;
		
		//@FindBy (xpath = "//p[@class='font12 redText appendTop5 makeFlex serverError hrtlCenter']/span[2]")
		@FindBy (xpath = "//p[@class='font12 redText appendTop5 makeFlex serverError hrtlCenter']//span[contains(text(),'Invalid phone number')]")
		WebElement assertionForRegInvalidMobileNumber; 
		
		//@FindBy (xpath = "//p[@class='validity font12 redText appendTop5 makeFlex']")
		@FindBy (xpath = "//p[contains(text(),'Please enter a valid Email Id or Mobile Number.')]")
		WebElement assertionForRegInvalidEmail; 
		
		@FindBy (xpath = "//span[@class='validity font12 redText appendTop5 makeFlex']")
		WebElement assertionForNewMobAndWrongOTP; 
		
		//@FindBy (xpath = "//span[@class='validity font12 redText appendTop5 makeFlex']")
		@FindBy (xpath = "//span[contains(text(),'Incorrect OTP Entered. Please try again.')]")
		WebElement assertionForNewEmailAndWrongOTP; 
		
		//@FindBy (xpath = "//p[@class='validity font12 redText appendTop5 makeFlex']")
		@FindBy (xpath = "//p[contains(text(),'Incorrect OTP! Please enter the OTP delivered to you.')]")
		WebElement assertionForRegMobAndWrongOTP; 
		
		//@FindBy (xpath = "//p[@class='font12 redText appendTop5 makeFlex serverError hrtlCenter']/span[2]")
		@FindBy (xpath = "//span[contains(text(),'Either Username or Password is incorrect.')]")
		WebElement assertionForRegEmailAndWrongPassword;
				
		@FindBy (xpath = "//div[@class='makeFlex column flexOne whiteText latoBold']/p")
		WebElement LoginOrCreateAccount;
		
		//CONSTRUCTOR TO INITIATE LOGINPAGE OBJECT WITH A DRIVER OBJECT
		
		public Register(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);// this will return Login page object with all												   
		}
		
		//METHODS RETURNING RESPECTIVE ELEMENTS
		
		public WebElement clickLoginOrCreateAccount() {
			return LoginOrCreateAccount;
		}
		
		public WebElement getAllInput() {
			return emailMobile;
		}
		/*
		public WebElement get_invalidMob() {						//INVALD MOBILE NUMBER
			//emailMobile.sendKeys(prps.getProperty("invalidMob"));
			return emailMobile;
		}		
		
		public WebElement get_invalidEmail() {						//INVALID EMAIL
			//emailMobile.sendKeys(prps.getProperty("invalidEmail"));
			return emailMobile;
		}
		public WebElement get_newMobile() {							//NEW MOBILE NUMBER
			//emailMobile.sendKeys(prps.getProperty("newMobile"));	
			return emailMobile;
		}
		public WebElement get_newEmail() {							//NEW EMAIL
			//emailMobile.sendKeys(prps.getProperty("newEmail"));
			return emailMobile;
		}
		public WebElement get_regMobile() {							//REGISTERED MOBILE NUMBER
			//emailMobile.sendKeys(prps.getProperty("regMobile"));	
			return emailMobile;
		}
		public WebElement get_regEmail() {							//REGISTERED EMAIL
			//emailMobile.sendKeys(prps.getProperty("regEmail"));
			return emailMobile;
		}
		*/
			
		public WebElement regOTP() {
			return regOTP;
		}
		public WebElement validText() {
			return validText;
		}
		public WebElement newRegOTP() {
			return newRegOTP;
		}
		public WebElement regEmailPassword() {
			return regEmailPassword;
		}
		public WebElement click_continueLogin() {
			return continueLogin;
		}	
		
		//ASSERTION METHODS FOR DIFFERENT INVALID INPUTS
		
		public WebElement assertionForRegInvalidMobileNumber() {
			return assertionForRegInvalidMobileNumber; 
		}	
		public WebElement assertionForRegInvalidEmail() {
			return assertionForRegInvalidEmail; 
		}	
		public WebElement assertionForNewMobAndWrongOTP() {
			return assertionForNewMobAndWrongOTP; 
		}	
		public WebElement assertionForNewEmailAndWrongOTP() {
			return assertionForNewEmailAndWrongOTP; 
		}	
		public WebElement assertionForRegMobAndWrongOTP() {
			return assertionForRegMobAndWrongOTP; 
		}	
		public WebElement assertionForRegEmailAndWrongPassword() {
			return assertionForRegEmailAndWrongPassword; 
		}
		/*
		 	public void assertionForRegInvalidEmail() {
			String registerError=driver.findElement(By.xpath("//p[@class='validity font12 redText appendTop5 makeFlex']")).getText();
			Assert.assertEquals(registerError, "Please enter a valid Email Id or Mobile Number.");   
			System.out.println("Assertion Successful");	
		}
		public void assertionForNewMobAndWrongOTP() {
			String newRegError=driver.findElement(By.xpath("//span[@class='validity font12 redText appendTop5 makeFlex']")).getText();
			Assert.assertEquals(newRegError, "Incorrect OTP Entered. Please try again.");   
			System.out.println("Assertion Successful");
		}
		public void assertionForNewEmailAndWrongOTP() {
			String newRegError=driver.findElement(By.xpath("//span[@class='validity font12 redText appendTop5 makeFlex']")).getText();
			Assert.assertEquals(newRegError, "Incorrect OTP Entered. Please try again.");   
			System.out.println("Assertion Successful");
		}
		public void assertionForRegMobAndWrongOTP() {
			String loginError=driver.findElement(By.xpath("//p[@class='validity font12 redText appendTop5 makeFlex']")).getText();
			Assert.assertEquals(loginError, "Incorrect OTP! Please enter the OTP delivered to you.");   
			System.out.println("Assertion Successful");	
		}
		public void assertionForRegEmailAndWrongPassword() {
			String loginError=driver.findElement(By.xpath("//p[@class='font12 redText appendTop5 makeFlex serverError hrtlCenter']/span[2]")).getText();
			Assert.assertEquals(loginError, "Either Username or Password is incorrect.");  	
			System.out.println("Assertion Successful");
		}
		 */
}


