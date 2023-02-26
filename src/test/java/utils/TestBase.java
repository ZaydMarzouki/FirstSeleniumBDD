package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
public static WebDriver driver;
public static Properties properties;
public TestBase() throws IOException { 
	properties = new Properties();
	FileInputStream file = new FileInputStream ("src\\test\\resources\\configs\\config.properties");
	properties.load(file);
	
}

public void initialization() {
	System.setProperty("webdriver.chrome.driver", properties.getProperty("pathDriver"));
	// open browser
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage ().timeouts().implicitlyWait(Duration.ofMillis(300));
	
}

}