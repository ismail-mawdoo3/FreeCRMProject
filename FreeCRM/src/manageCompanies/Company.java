package manageCompanies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import configuration.ConfigClass;

public class Company extends ConfigClass {

	// Define By objects
	By CompanyLinkLocator = By.xpath("//*[@id=\"navmenu\"]/ul/li[3]/a");

	@Test
	public void addCompany() {
		
		System.out.println(driver.getCurrentUrl());						
		/*	WebElement CompanyLinkElement=driver.findElement(CompanyLinkLocator);
			System.out.println("company 44 ");
			Actions actions=new Actions(driver);
			actions.moveToElement(CompanyLinkElement).build().perform();*/
				
	}
}
