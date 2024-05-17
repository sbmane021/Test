package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		List<WebElement> w=driver.findElements(By.className("flatpickr-day "));
		int count=driver.findElements(By.className("flatpickr-day ")).size();
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.className("flatpickr-day ")).get(i).getText();
			if(text.equalsIgnoreCase("23"))
			{
				driver.findElements(By.className("flatpickr-day ")).get(i).click();
				break;
			}
		}

	}

}
