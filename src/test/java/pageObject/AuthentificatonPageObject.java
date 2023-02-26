package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthentificatonPageObject {

	WebDriver driver;
	/** locators **/

	@FindBy(id = "user-name")
	WebElement user;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement login;

	@FindBy(xpath = "//span[@class='title']")
	WebElement product;

	public AuthentificatonPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterUserName() {
		user.sendKeys("standard_user");
	}

	public void enterUserPassword() {
		password.sendKeys("secret_sauce");

	}

	public void clickButton() throws InterruptedException {
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.click(login).perform();

	}

	public void enterUserName(String name) {
		user.sendKeys(name);
	}

	public void enterUserPassword(String pws) {
		password.sendKeys(pws);
	}

	public void verifyInventoryPage() {
		System.out.println(product.getText());
		String pageExpected = "PRODUCTS";
		String pageActual = product.getText();
		assertEquals(pageExpected, pageActual);

	}
}
