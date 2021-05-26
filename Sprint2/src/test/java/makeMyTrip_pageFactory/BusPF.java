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



public class BusPF extends TestBase {
	
	//WebDriver driver;
	
	@FindBy (linkText = "Buses")
	WebElement Buses;
	
	@FindBy (xpath= "//span[contains(text(),'From')]")
	WebElement From;
	
	@FindBy (id = "search_button")
	WebElement search;
	
	//constructor to initiate LogInPage object with a driver object
			public BusPF(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);// this will return Login page object with all
													   // web elements initialized
			}
			
			public WebElement clickBuses() {
				return Buses;
			}
			public WebElement clickFrom() {
				return From;
			}
			public WebElement getFromLocation() {
				WebElement loc = driver.findElement(By.xpath("//span[contains(text(),'"+prps.getProperty("From")+"')]"));
				return loc;
			}
			public WebElement getToLocation() {
				WebElement loc = driver.findElement(By.xpath("//span[contains(text(),'"+prps.getProperty("To")+"')]"));
				return loc;
			}
			public WebElement getTravelDate() {
				WebElement tDate = driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'][1]//div[text()='"+prps.getProperty("TravelDate")+"']"));
				return tDate;
			}
			public WebElement getAssertion() {
				WebElement check = driver.findElement(By.xpath("//input[@value='"+prps.getProperty("From")+"']"));
				return check;
			}
			
			public WebElement clickSearch() {
				return search;
			}

}
