package Fargo.End2EndTesting;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest extends BaseClass {

	/*
	 * @BeforeTest public void browserSetting() {
	 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
	 * }
	 */

	@Test
	public void launchBrowser() throws IOException {
		driver = initialiseBrowser();
		// driver.get("https://www.spicejet.com/");
		// driver.get("https://www.tsrtconline.in/oprs-web/");
		driver.get(urlName);
		System.out.println(urlName);
	}
	
	@Test
	public void login()
	{
		HomePage hp=new HomePage(driver);
		hp.clickLogin().click();
		
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
