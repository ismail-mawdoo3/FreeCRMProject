package registerationANDLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configuration.Core;

public class SignUP extends Core{
	Core core = new Core();

	// Define By Locators
	By SignUplinkLocator = By.xpath("//a[@href='https://www.freecrm.com/register/']");
	By FNameFieldLcator = By.name("first_name");
	By LNameFieldLocator = By.name("surname");
	By EmailFieldLocator = By.name("email");
	By EmailConfirmFieldLocator = By.name("email_confirm");
	By UserNameFieldLocator = By.name("username");
	By PasswordFieldLocator = By.name("password");
	By PassConfirmFieldLocator = By.name("passwordconfirm");
	By AgreeCheckBoxlocator = By.name("agreeTerms");
	By SubmitBtnLocator = By.id("submitButton");
	By CompleteRegisteration = By.id("By.name(\"finish\")");

	// Define variables
	String RegisterUrlPage = "https://www.freecrm.com/register/";
	String Email = "hala_" + GenerateEmail(3) + "@mailinator.com";
	String UserName = "hala_" + GeneratUserName(3);
	String Password = "123456789a";
	String FName = "Hala";
	String LName = "Maree";

	@BeforeMethod
	public void setUpMethod() {
		// Enter to SignUp page
		waitElementToBeClickable(SignUplinkLocator).click();
		// Check you entered to Register page successfully
		Assert.assertEquals(driver.getCurrentUrl(), RegisterUrlPage, "You are not on register page");
	}

	@Test
	public void signUp() {

		// Fill Fields
		WebElement EditionDDL = driver.findElement(By.id("payment_plan_id"));
		Select EditionDropDownList = new Select(EditionDDL);
		EditionDropDownList.selectByValue("1");

		sendKeysToElement(FName, FNameFieldLcator);
		sendKeysToElement(LName, LNameFieldLocator);
		sendKeysToElement(Email, EmailFieldLocator);
		sendKeysToElement(Email, EmailConfirmFieldLocator);
		sendKeysToElement(UserName, UserNameFieldLocator);
		sendKeysToElement(Password, PasswordFieldLocator);
		sendKeysToElement(Password, PassConfirmFieldLocator);

		// select agree checkbox then submit
		waitElementToBeClickable(AgreeCheckBoxlocator).click();
		waitElementToBeClickable(SubmitBtnLocator).click();
		
		//Fill company information
		SignUpCompanyInfo();
		
		//Complete Registration
		waitElementToBeClickable(CompleteRegisteration).click();
	}

	public void SignUpCompanyInfo() {

		// Define By locators
		By CompanyFieldLocator = By.id("company_name");
		By PhoneFieldLocator = By.id("phone");
		By CountryDDLLocator = By.name("country");
		By BillingCheckBoxLocator = By.name("copy_address");
		By ContinueBtnLocator = By.name("btnSubmit");

		// Define variables
		String CompanyName = "IE company";
		String Phone = "0096296986541";

		sendKeysToElement(CompanyName, CompanyFieldLocator);
		sendKeysToElement(Phone, PhoneFieldLocator);

		WebElement CountryDropDownList = driver.findElement(CountryDDLLocator);
		Select CountryDDL = new Select(CountryDropDownList);
		CountryDDL.selectByValue("Jordan");

		waitElementToBeClickable(BillingCheckBoxLocator).click();
		waitElementToBeClickable(ContinueBtnLocator).click();

	}

	@AfterMethod
	public void tearDownMethod() {
		System.out.println("The registered username is " + UserName + " and Email is " + Email);
	}

}
