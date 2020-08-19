package Fargo.End2EndTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}
	
	By lgnlink=By.cssSelector("a[href*='login']");
	
	public WebElement clickLogin()
	{
		return driver.findElement(lgnlink);
	}
	

}
