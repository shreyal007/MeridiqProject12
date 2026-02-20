package testLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMERIDIQLogin 
{
 
	public static WebDriver driver;
	 
	@Test(priority=1)
	void login() throws InterruptedException
	{
		
		  WebDriverManager.chromedriver().setup();
		  
		  driver = new ChromeDriver();
		  
		  driver.get("https://early-access.meridiq.com/");
		  Thread.sleep(5000);
		  
		  /*driver.findElement(By.xpath("//input[@type='password']")).sendKeys("LightSaber");
		  Thread.sleep(3000);
		
		  driver.findElement(By.xpath("//button[text()='Submit']")).click();
		  Thread.sleep(5000);*/
		  
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("srshah1231998@gmail.com");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pa$$w0rd!!!!");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//div[text()='Login Now']")).click();
		  Thread.sleep(5000);
				
		  /*SoftAssert softAssert = new SoftAssert();
		  
		  // Get text and assert
		  String actualText = driver.findElement(By.xpath("//h4[text() = 'Main Dashboard']")).getText();
		  System.out.println("Actual Text : " +actualText);
				
		  //Assert Not equal
		  softAssert.assertEquals(actualText, "Expected Text : Main Dashboard", "Text mismatch found!");
		  
		  // Must call at end to report all failures
		  softAssert.assertAll();*/
		  
		  //Get actual Text
		  String actualText = driver.findElement(By.xpath("//h4[text() = 'Main Dashboard']")).getText();
		  String expectedText = "Main Dashboard";
		  
		  //Print in console for visibility
		  System.out.println("Expected Text:" + expectedText);
		  System.out.println("Actual Text:" + actualText);
		  
		  // Assert with meaningful failure message
		  Assert.assertEquals(actualText, expectedText, "Text verification failed! Actual text does not match expected.");	  
		  	
	}
	
	@Test(priority=2)
	void quitBrowser()
	{
		
		driver.quit();
		
	}
	
}
