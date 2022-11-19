package drithishettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		//initialization
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement useremail = driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password1;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	public void loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		password1.sendKeys(password);
		submit.click();
	}
	
	public void goTo()
	{
		 driver.get("https://rahulshettyacademy.com/client");
	}
}
