package Selenium;



import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Software/chromedriver.exe");
		
		//WebDriverManager.chromeDriver().setup();
		String name= "shitalmane@gmail.com";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("Shital@21");
		driver.findElement(By.className("submit")).click();
		String text = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(text);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Shital");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sbmane@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9876543210");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click(); 
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	    driver.quit();		
	}

}
