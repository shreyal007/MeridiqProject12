package testAddClient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAddClientManually 
{

	public static WebDriver driver;
	
	Faker faker = new Faker();
	
	@BeforeTest
	void login() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://early-access.meridiq.com/");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("srshah1231998@gmail.com");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pa$$w0rd!!!!");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text() = 'Login Now']")).click();
		Thread.sleep(5000);		
		
	}
	
	@Test(priority=1)
	void clickOnClientMenu() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[text()= 'Clients']")).click();
		Thread.sleep(3000);		
		
	}
	
	@Test(priority=2)
	void addClient() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//p[text()= 'Merge']//following::*[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder= 'First name']")).sendKeys(faker.name().firstName());
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder= 'Last name']")).sendKeys(faker.name().lastName());
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder= 'E-mail']")).sendKeys(faker.internet().safeEmailAddress());
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text() = 'Submit']")).click();
		Thread.sleep(10000);
		
	}
	
	@AfterTest
	void quitBrowser()
	{
		
		driver.quit();
		
	}
	
	
}
