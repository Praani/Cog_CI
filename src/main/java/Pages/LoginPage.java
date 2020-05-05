package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By userName = By.name("email");
	By passcode = By.name("password");
	By loginButton = By.xpath("//div[contains(text(),'Login')]");
	
	public void login(String Name, String pass) {
		driver.findElement(userName).sendKeys(Name);
		driver.findElement(passcode).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
}
