package Selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] productName= {"Brocolli","Cucumber","Beetroot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(6000);
		addToCart(driver,productName);
	}


public static void addToCart(WebDriver driver,String[] productName)
{
	int j=0;
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
	
	for(int i=0;i<products.size();i++)
	{
		
		String[] name= products.get(i).getText().split("-");
		String formattedName=name[0].trim();
		List itemsNeeded=Arrays.asList(productName);
		
		if(itemsNeeded.contains(formattedName))
		{
			j++;
			driver.findElements(By.xpath("//div[@clss='product-action']/button")).get(i).click();
		
			if(j==productName.length)
				break;
		}
	}

}

}
