package RegisterationANDLogin;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Configuration.Core;

public class Login extends Core {
	// Define global variables
	String HomePageURL = "https://www.freecrm.com/index.html";

	// Define By objects
	By UsernameLoginPageLocator = By.name("username");
	By PassLoginPageLocator = By.name("password");
	By LoginBtnLocator = By.xpath("//input[@value='Login']");

	@Test
	public void loginUser() {

		// Make sure you are on Login page
		Assert.assertEquals(driver.getCurrentUrl(), HomePageURL, "You are not on Home Page");

		// Fill user credentials
		sendKeysToElement("hala77", UsernameLoginPageLocator);
		sendKeysToElement("123456789a", PassLoginPageLocator);

		// click - Submit

		waitElementToBeClickable(LoginBtnLocator).click();
		
	
		String screenShotPath="c:\\file\\screenshot_"+ getCurrentTime()+".png";
		// Take Screenshot
		takeScreenShot(screenShotPath);

	}

}
