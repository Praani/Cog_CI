package Test;

import org.testng.annotations.Test;

import Pages.Basepage;
import Pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Tests {
	WebDriver driver;
	Basepage bp;
	LoginPage lp;

	@Parameters({ "URL" })
	@BeforeMethod
	public void browser_config(String link) throws IOException {
		bp = new Basepage(driver);
		driver = bp.initializ_driver();
		driver.get(link);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Login() {
		lp = new LoginPage(driver);
		lp.login("Praneshk92@gmail.com", "NewUser@12345");
		System.out.println("Login test Passed");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
