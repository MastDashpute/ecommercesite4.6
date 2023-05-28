package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	private By email = By.xpath("//input[@id='email']");
	private By password = By.id("pass");
	private By loginBtn = By.id("send2");
	private By CreateAccount_Btn =By.xpath("//span[contains(text(),'Create an Account')]");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void sendUserName(String username) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(username);
	}
	
	public void sendPassword(String password) {
		driver.findElement(this.password).clear();
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickOnloginBtn() {
		driver.findElement(loginBtn).click();
	}

	public void clickonCreateAccountBtn() {
		driver.findElement(CreateAccount_Btn).click();
	}
	
	
}
