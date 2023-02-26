package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinitions {
	WebDriver driver;
	WebElement firstName = driver.findElement(By.id("firstName"));
	WebElement lastName = driver.findElement(By.id("lastName"));
	WebElement email = driver.findElement(By.id("userEmail"));
	WebElement gender = driver.findElement(By.id("gender-radio-2"));
	WebElement mobile = driver.findElement(By.id("userNumber"));
	
	
	@Given("I open the student registration website")
	public void i_open_the_student_registration_website() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		// open browser
			driver = new ChromeDriver();
				
				driver.get("https://demoqa.com/automation-practice-form");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
	}

	@When("I enter form")
	public void i_enter_form() throws InterruptedException {
		
		firstName.sendKeys("neila");
		
		lastName.sendKeys("ben mbarek");
		
		email.sendKeys("benmbarekneila@gmail.com");
		
	    Actions actions = new Actions(driver);
	    Thread.sleep(3000);
	    actions.click(gender).perform();
		
		mobile.sendKeys("26220836");
	

	
		
		
		
		
		
		
		
		
	
		
	}

	
}
