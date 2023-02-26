package steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasic {

	private static WebDriver driver = null;
	public static Properties properties;
	
	
	public static void main(String[] args) {
		properties = new Properties();
		properties.setProperty("pathDriver", "drivers/chromedriver.exe");

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("URL", "This is an authentification test");

		System.setProperty("webdriver.chrome.driver", properties.getProperty("pathDriver"));

		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.saucedemo.com/");
		test1.pass("Navigated to the URL");

		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Test Completed");

		// calling flush writes everything to the log file
		extent.flush();
	}

}
