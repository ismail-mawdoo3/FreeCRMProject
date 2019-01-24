package Configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigClass {
	// Define global variables and objects
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public static String baseURL = "";
	public static String Browser = "";

	@BeforeTest
	@Parameters({ "baseURL", "Browser" })
	public void config(@Optional("") String baseURL, @Optional("") String Browser) {
		// Define variables
		this.baseURL = baseURL;
		this.Browser = Browser;

		switch (Browser.toLowerCase()) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}

		default: {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		}
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 6);
	}

	@AfterTest
	public void tearDown() {
		System.out.println("end");
	}
}
