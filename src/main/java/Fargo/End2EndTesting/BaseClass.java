package Fargo.End2EndTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BaseClass {
	//public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public WebDriver driver;
	public Properties prop;
	public String urlName;

	public WebDriver initialiseBrowser() throws IOException {
		prop = new Properties();
		//System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");

		prop.load(fis);
		String browserName =System.getProperty("browser");
	//	String browserName = prop.getProperty("browser");
		urlName = prop.getProperty("url");
		System.out.println(browserName);
		System.out.println(urlName);

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions option =new ChromeOptions();
			if(browserName.contains("headless")){
				option.addArguments("headless");
			}
				
			driver = new ChromeDriver(option);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
