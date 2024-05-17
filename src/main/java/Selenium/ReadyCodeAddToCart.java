package Selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadyCodeAddToCart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//WebDriverWait w= new WebDriverWait(driver,5);
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addToCart(driver,itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		//w.until(ExpectedConditions.visibilityOf(By.cssSelector("button.promoBtn")));
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
		
}
	
public static void addToCart(WebDriver driver,String[] itemsNeeded)
{
	int j = 0;
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

	for (int i = 0; i < products.size(); i++)

	{
		String[] name = products.get(i).getText().split("-");
		String formattedName = name[0].trim();
		List itemsNeededList = Arrays.asList(itemsNeeded);

		if (itemsNeededList.contains(formattedName))

		{

			j++;
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

			if (j == itemsNeeded.length)
				break;

		}
	}
	
}

}
