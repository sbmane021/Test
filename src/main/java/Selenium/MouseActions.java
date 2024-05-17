package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).build().perform();
		driver.get("https://www.google.com/");
		a.moveToElement(driver.findElement(By.id("APjFqb"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(driver.findElement(By.id("APjFqb"))).contextClick().build().perform();
	
	}

}
