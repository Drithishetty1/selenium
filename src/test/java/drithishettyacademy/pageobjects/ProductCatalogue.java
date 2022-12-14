package drithishettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		//initialization
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	
	public getProductList()
	
	{
		waitForElementToAppear(); 
		return products;
	}
	
}
