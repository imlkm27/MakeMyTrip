package makeMyTrip_stepDefinition;

import java.util.concurrent.TimeUnit;

import org.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import makeMyTrip_pageFactory.BusPF;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import makeMyTrip_pageFactory.Register;

public class StepDefinition extends TestBase {
	
	//WebDriver driver;
	
	//<------------------------------------------------------------------------------------------------------------------>
	//BACKGROUND FILE
	@Given("^User is on Landing Page$")
	public void user_is_on_Landing_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",  prps.getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get(prps.getProperty("url"));	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		Actions act = new Actions(driver);
		WebElement sam = driver.findElement(By.xpath("//p[@class='appendBottom3 whiteText']"));
		act.moveToElement(sam).click().build().perform();
		Thread.sleep(2000);				
		Register obj = new Register(driver);
		obj.clickLoginOrCreateAccount().click();
		Thread.sleep(2000);
	
	}	
	public static boolean isNumber(String s)
	{
		for (int i = 0; i < s.length(); i++)
			if (Character.isDigit(s.charAt(i)) == false)
				return false;
		return true;
	}
	
	//<------------------------------------------------------------------------------------------------------------------>
	//REGISTER WITH INVALID MOBILE NUMBER(TEST-1)
	@When("^User enters invalid mobile number\"([^\"]*)\" and clicks on Continue button$")
	public void user_enters_invalid_mobile_number_and_clicks_on_Continue_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		//89999
		/*
		if (isNumber(prps.getProperty("invalidMob"))) {
			System.out.println("Integer");
		lpage.getAllInput().sendKeys(prps.getProperty("invalidMob"));	
		lpage.click_continueLogin().click();
		}
		else {
			System.out.println("Invalid Number Its a String");
			driver.quit();
		}*/
		lpage.getAllInput().sendKeys(prps.getProperty("invalidMob"));	
		lpage.click_continueLogin().click();
	}
	@Then("^User gets an Error message for invalid mobile number$")
	public void user_gets_an_Error_message_for_invalid_mobile_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		String registerError=lpage.assertionForRegInvalidMobileNumber().getText();
		Assert.assertEquals(registerError, "Invalid phone number", "NOT MATCHED");   
		System.out.println("Assertion Successful For Invalid phone number, NOT MATCHED");			
		driver.quit();
	}

	//<------------------------------------------------------------------------------------------------------------------>
	//REGISTER WITH INVALID EMAIL(TEST-2)
	@When("^User enters invalid email \"([^\"]*)\" and clicks on text for pop message to appear$")
	public void user_enters_invalid_email_and_clicks_on_text_for_pop_message_to_appear(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.getAllInput().sendKeys(prps.getProperty("invalidEmail"));
		//likith
		lpage.validText().click();
		
	}
	@Then("^User gets an Error message for invalid email$")
	public void user_gets_an_Error_message_for_invalid_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		String registerError=lpage.assertionForRegInvalidEmail().getText();
		Assert.assertEquals(registerError, "Please enter a valid Email Id or Mobile Number.");   
		System.out.println("Assertion Successful For Please enter a valid Email Id or Mobile Number.");	
		driver.quit();
	}
	
	//<------------------------------------------------------------------------------------------------------------------>
	//NEW MOBILE NUMBER AND WRONG OTP(TEST-3)
	@When("^User enters new mobile number \"([^\"]*)\" and clicks on Continue button$")
	public void user_enters_new_mobile_number_and_clicks_on_Continue_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.getAllInput().sendKeys(prps.getProperty("newMobile"));	
		//8660016562
		lpage.click_continueLogin().click();
		Thread.sleep(5000);	
	}
	@When("^User enters invalid OTP and clicks on Verify and Create Account button$")
	public void user_enters_invalid_OTP_and_clicks_on_Verify_and_Create_Account_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.newRegOTP().sendKeys("000000");
		lpage.click_continueLogin().click();
	}
	@Then("^User gets an Error message for invalid OTP for new mobile number$")
	public void user_gets_an_Error_message_for_invalid_OTP_for_new_mobile_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		String newRegError=lpage.assertionForNewMobAndWrongOTP().getText();
		Assert.assertEquals(newRegError, "Incorrect OTP Entered. Please try again.");   
		System.out.println("Assertion Successful For Incorrect OTP Entered. Please try again.");
		driver.quit();
	}
	
	//<------------------------------------------------------------------------------------------------------------------>
	//NEW EMAIL AND WRONG OTP(TEST-4)
	@When("^User enters new email \"([^\"]*)\" and clicks on Continue button$")
	public void user_enters_new_email_and_clicks_on_Continue_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.getAllInput().sendKeys(prps.getProperty("newEmail"));
		//likith87965823256@gmail.com
		lpage.click_continueLogin().click();
		Thread.sleep(5000);
		//Already Method is defined!!!!!!!!!!!!
	}
	@Then("^User gets an Error message for invalid OTP for new Email$")
	public void user_gets_an_Error_message_for_invalid_OTP_for_new_Email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		String newRegError=lpage.assertionForNewEmailAndWrongOTP().getText();
		Assert.assertEquals(newRegError, "Incorrect OTP Entered. Please try again.");   
		System.out.println("Assertion Successful For Incorrect OTP Entered. Please try again.");
		driver.quit();
	}

	//<------------------------------------------------------------------------------------------------------------------>
	//REGISTER MOBILE NUMBER AND WRONG OTP(TEST-5)
	@When("^User enters registered mobile number \"([^\"]*)\" and clicks on Continue button$")
	public void user_enters_registered_mobile_number_and_clicks_on_Continue_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.getAllInput().sendKeys(prps.getProperty("regMobile"));
		//8660016560
		lpage.click_continueLogin().click();
		Thread.sleep(5000);		
	}
	@When("^User enters invalid OTP and clicks on Login button$")
	public void user_enters_invalid_OTP_and_clicks_on_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.regOTP().sendKeys("000000");
		lpage.click_continueLogin().click();
	}
	@Then("^User gets an Error message for invalid OTP for registered mobile number$")
	public void user_gets_an_Error_message_for_invalid_OTP_for_registered_mobile_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		String loginError=lpage.assertionForRegMobAndWrongOTP().getText();
		Assert.assertEquals(loginError, "Incorrect OTP! Please enter the OTP delivered to you.");   
		System.out.println("Assertion Successful For Incorrect OTP! Please enter the OTP delivered to you.");	
		driver.quit();
	}

	//<------------------------------------------------------------------------------------------------------------------>
	//REGISTER EMAIL AND WRONG PASSWORD(TEST-6)
	@When("^User enters registered email \"([^\"]*)\" and clicks on Continue button$")
	public void user_enters_registered_email_and_clicks_on_Continue_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.getAllInput().sendKeys(prps.getProperty("regEmail"));
		//likithliki8@gmail.com
		lpage.click_continueLogin().click();
		Thread.sleep(5000);	
	}
	@When("^User enters invalid Password and clicks on Login button$")
	public void user_enters_invalid_Password_and_clicks_on_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		lpage.regEmailPassword().sendKeys("Likith");
		lpage.click_continueLogin().click();
	}
	@Then("^User gets an Error message for invalid password for registered email$")
	public void user_gets_an_Error_message_for_invalid_password_for_registered_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Register lpage = new Register(driver);
		String loginError=lpage.assertionForRegEmailAndWrongPassword().getText();
		Assert.assertEquals(loginError, "Either Username or Password is incorrect.");  	
		System.out.println("Assertion Successful For Either Username or Password is incorrect.");
		driver.quit();
	}
	
	//<------------------------------------------------------------------------------------------------------------------>
		//BUSES FUNCTIONALITY(TEST-1)	
	
		@Given("^User is in on Landing page for Buses$")
		public void user_is_in_on_Landing_page_for_Buses() throws Throwable {
			// Write code here that turns the phrase above into concrete actions  
			System.setProperty("webdriver.chrome.driver", prps.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize(); 
			driver.get(prps.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			Actions act = new Actions(driver);
			WebElement sam = driver.findElement(By.xpath("//p[@class='appendBottom3 whiteText']"));
			act.moveToElement(sam).click().build().perform();
		}
		@When("^User clicks on Buses link$")
		public void user_clicks_on_Buses_link() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			BusPF obj = new BusPF(driver);
			obj.clickBuses().click();
			Thread.sleep(2000);
		}
		@When("^User selects From \"([^\"]*)\" location$")
		public void user_selects_From_location(String arg1) throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			BusPF obj = new BusPF(driver);
			obj.clickFrom().click();	//Clicks on From Button
			obj.getFromLocation().click();
			Thread.sleep(2000);
		}
		@When("^User selects To \"([^\"]*)\" location$")
		public void user_selects_To_location(String arg1) throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			BusPF obj = new BusPF(driver);
			obj.getToLocation().click();
			Thread.sleep(2000);	
		}
		@When("^User selects TRAVEL DATE$")
		public void user_selects_TRAVEL_DATE() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			BusPF obj = new BusPF(driver);
			obj.getTravelDate().click();	
			/*
			Boolean temp = driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[contains(text(),'June 2021')]")).isDisplayed();
			if(temp) {
				driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[contains(text(),'June 2021')]//div[contains(text(),'29')]")).click();
				
				//driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[contains(text(),'29')]")).click();				
			}
			*/
			Thread.sleep(2000);
		}
		@Then("^User clicks on SEARCH button$")
		public void user_clicks_on_SEARCH_button() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			BusPF obj = new BusPF(driver);
			obj.clickSearch().click();
			Thread.sleep(2000);
			//------------------------CHECKING FOR ASSERTION---------------------------------->>
			Boolean val = obj.getAssertion().isDisplayed();	
			Assert.assertTrue(val); 
			System.out.println("Assertion Successful For searching of Buses");	
			Thread.sleep(2000);
			driver.quit();
		}
	}
