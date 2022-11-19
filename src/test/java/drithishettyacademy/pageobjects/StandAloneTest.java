package drithishettyacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
          WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
         // driver.manage().window().maximize();
          
          LandingPage landingPage = new  LandingPage(driver);
          landingPage.goTo();
         landingPage.loginApplication("drithi1996@gmail.com", "Name@123");
         
         
         WebDriverWait  wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
         
         List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
         
        WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
         
       prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
       
       WebDriverWait  wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
       
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
       driver.findElement(By.xpath("//ul/li[4]")).click();
       List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
     Boolean match =  cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
       Assert.assertTrue(match);
       WebDriverWait  wait1 = new  WebDriverWait(driver,Duration.ofSeconds(6));
       driver.findElement(By.xpath("//div/ul/li[3]")).click();
      // driver.findElement(By.xpath("//form/div/div[2]/div/input")).sendKeys("123");
      // driver.findElement(By.xpath("//form/div/div[3]/div/input")).sendKeys("Drithi Shetty");
      // driver.findElement(By.xpath("//form/div/div[4]/div/input")).sendKeys("offer50");
      // WebDriverWait  wait2 = new  WebDriverWait(driver,Duration.ofSeconds(6));
      // driver.findElement(By.className("btn btn-primary mt-1")).click();
       Actions a = new Actions(driver);
       a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
       driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]")).click();
       driver.findElement(By.cssSelector(".action__submit")).click();
       String confirmmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
       driver.close();
       
       //html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]
	}

}
