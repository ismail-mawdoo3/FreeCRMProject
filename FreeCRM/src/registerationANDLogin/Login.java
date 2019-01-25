package registerationANDLogin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import configuration.Core;

public class Login extends Core {
	// Define global variables
	String HomePageURL = "https://www.freecrm.com/index.html";

	// Define By objects
	By UsernameLoginPageLocator = By.name("username");
	By PassLoginPageLocator = By.name("password");
	By LoginBtnLocator = By.xpath("//input[@value='Login']");
	By LogoutLinkLocator = By.xpath("//*[contains(@href,'logout')]");

	@Test
	public void loginUser() {
		
		//
		String MainFrame="mainpanel";
		// Make sure you are on Login page
		Assert.assertEquals(driver.getCurrentUrl(), HomePageURL, "You are not on Home Page");

		// Fill user credentials
		sendKeysToElement("hala77", UsernameLoginPageLocator);
		sendKeysToElement("123456789a", PassLoginPageLocator);

		// click - Submit
		waitElementToBeClickable(LoginBtnLocator).click();

		// Evidence by 1.take Screenshot 2.existence of logout link
		takeScreenShot(screenShotPath);
		driver.switchTo().frame(MainFrame);
		waitElementToBeVisible(LogoutLinkLocator);
	}

}
