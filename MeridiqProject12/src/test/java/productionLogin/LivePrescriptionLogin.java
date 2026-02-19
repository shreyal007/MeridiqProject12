package productionLogin;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LivePrescriptionLogin 
{
	
	public static WebDriver driver;
 
	@Test(priority=1)
	void login() throws InterruptedException
	{
		
		  WebDriverManager.chromedriver().setup();
		  
		  driver = new ChromeDriver();
		  
		  driver.get("https://app.meridiq.com/prescription/login");
		  Thread.sleep(5000);
		  
//		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("LightSaber");
//		  Thread.sleep(3000);
//		
//		  driver.findElement(By.xpath("//button[text()='Submit']")).click();
//		  Thread.sleep(5000);
//		  
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rickard.nurlin@gmail.com");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Hello123456");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//div[text()='Login Now']")).click();
		  Thread.sleep(5000);
		  	
	}
	
	@Test(priority=2)
	void quitBrowser()
	{
		
		driver.quit();
		
	}
	
}
