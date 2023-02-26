package steps;

import java.io.IOException;

import org.openqa.selenium.By;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AuthentificatonPageObject;
import utils.TestBase;

public class AuthentificationStepDefinition extends TestBase {

	// WebDriver driver;
	AuthentificatonPageObject authentificatonPageObject;

	public AuthentificationStepDefinition() throws IOException {
		super();
	}

	@Before
	public void setup() {
		initialization();
	}

	@Given("I navigate on website")
	public void i_navigate_on_website() {
		driver.get(properties.getProperty("URL"));
	}

	@When("I enter username")
	public void i_enter_username() {
		authentificatonPageObject = new AuthentificatonPageObject(driver);
		authentificatonPageObject.enterUserName();

	}

	@When("I enter password")
	public void i_enter_password() {

		authentificatonPageObject.enterUserPassword();

	}

	@When("I click on login button")
	public void i_click_on_login_button() throws InterruptedException {

		authentificatonPageObject.clickButton();
	}

	@Then("the inventory page shows")
	public void the_inventory_page_shows() {
	}

	@When("I enter username {string}")
	public void i_enter_username(String username) {
		authentificatonPageObject = new AuthentificatonPageObject(driver);
		authentificatonPageObject.enterUserName(username);
	}

	@When("I enter {string} and {string}")
	public void i_enter_and(String login, String pwdUser) {
		authentificatonPageObject = new AuthentificatonPageObject(driver);
		authentificatonPageObject.enterUserName(login);
		authentificatonPageObject.enterUserPassword(pwdUser);
		
	   
	}

	

	@After
	public void quit() {
		driver.quit();
	}

}
