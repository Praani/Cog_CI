package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basepage {
	public WebDriver driver;

	public Basepage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver initializ_driver() throws IOException {
		Properties prop = new Properties();
		FileInputStream datafile = new FileInputStream(
				"/home/pranesh/Documents/Eclipse_Home/Cog/src/main/java/Utils/cogmento.properties");
		prop.load(datafile);
		String browserName = prop.getProperty("browser");
		System.out.println("This is " + browserName +" browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			//String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + "/Drivers/FireFox/geckodriver");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No browser found");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

}
