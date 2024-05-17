package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeLinksCount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//overall links in webpage
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		//limiting webdriver scope to footer
		WebElement footerDriver= driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		//limiting scope to small section of footer
		WebElement footerSmallSection= driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footerSmallSection.findElements(By.tagName("a")).size());
		//click on every link in the footerSmallSection
		for(int i=0;i<footerSmallSection.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinktab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerSmallSection.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			
			Thread.sleep(3000);
		}
		Set<String> w= driver.getWindowHandles();
		Iterator<String> it =w.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
 