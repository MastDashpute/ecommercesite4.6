package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TVMenuPage {
	WebDriver driver;
	
	public TVMenuPage(WebDriver driver){
		this.driver = driver;
	}
	
	By AddToWishListBtn = By.xpath("(//a[@class='link-wishlist'])[1]");
	By shareWishListBtn = By.xpath("//span[contains(text(),'Share Wishlist')]");
	By emaildiInput = By.xpath("//textarea[@id='email_address']");
	By sharing_info_msg_Btn = By.xpath("//textarea[@id='message']");
	By SHAREWISHLISTtBtn = By.xpath("//span[contains(text(),'Share Wishlist')]");
	By WishListSharedSuccessMsg = By.xpath("//span[normalize-space()='Your Wishlist has been shared.']");
	
	
	
	public void click_On_AddToWishList() {
		driver.findElement(AddToWishListBtn).click();
	}

	public void click_on_shareWishList() {
		driver.findElement(shareWishListBtn).click();
	}
	
	public void sharingInformation(String emailid) {
		driver.findElement(emaildiInput).sendKeys(emailid);
		driver.findElement(sharing_info_msg_Btn).sendKeys("Hey, see what I liked, i liked it and i shared it only with you");
		driver.findElement(SHAREWISHLISTtBtn).click();
	}
	
	public String checkWishListSharedSuccessfully() {
	String WishListShared_msg	= driver.findElement(WishListSharedSuccessMsg).getText();
	return WishListShared_msg;
	}
}
