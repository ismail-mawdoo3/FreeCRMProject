package Configuration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Core extends ConfigClass {

	public WebElement waitElementToBeClickable(By by) {

		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement waitElementToBeVisible(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public void sendKeysToElement(String text, By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);

	}

	public String GeneratUserName(int length) {

		boolean useLetters = true;
		boolean useNumbers = true;
		String UserName = RandomStringUtils.random(length, useLetters, useNumbers);
		return UserName;
		
	}
	
	public String GenerateEmail(int length) {
		String  NumberPart=RandomStringUtils.random(length,true,true);
				
		return NumberPart;
		
		
		
	}
	
	
	

}
