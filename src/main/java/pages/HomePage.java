package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	WebDriver driver;
	By mobilemenu = By.xpath("//a[normalize-space()='Mobile']");
	By TVmenu = By.xpath("//a[normalize-space()='TV']");
	By MyAccountLinkBtn = By.xpath("//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']");
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
	}

	public String getHomePgTitle() {
		String HomepgTitle = driver.getTitle();
		return HomepgTitle;
	}
	public void clickOnMobileMenu() {
		driver.findElement(mobilemenu).click();
		
	}
	public void clickOnMyAccntBtn() {
		driver.findElement(MyAccountLinkBtn).click();
	}
	public void clickTVMenu() {
		driver.findElement(TVmenu).click();
		
	}
	
}

