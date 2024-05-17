package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		WebElement staticDropDown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s= new Select(staticDropDown);
		s.selectByIndex(2);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByVisibleText("USD");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("INR");
		System.out.println(s.getFirstSelectedOption().getText());
		driver.close();
	}

}
