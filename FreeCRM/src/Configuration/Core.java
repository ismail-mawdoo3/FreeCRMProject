package Configuration;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		String NumberPart = RandomStringUtils.random(length, true, true);
		return NumberPart;
	}
	
	
public void takeScreenShot(String path) {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	try {
		FileUtils.copyFile(scrFile, new File(path));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public String  getCurrentTime(){
    Date date = new Date();
    String dateTimeformat="hh_mm_ss_a";
    DateFormat dateFormat = new SimpleDateFormat(dateTimeformat);
    String formattedDate= dateFormat.format(date);
	return formattedDate;
}

}
