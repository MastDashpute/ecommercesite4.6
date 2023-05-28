package pages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MobileMenuPg {
	WebDriver driver;
	By sortbydd = By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]");
	By addToCartSonyButton = By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]");
	By qtyInputSonybtn = By.xpath("//input[@title='Qty']");
	By updateBtnSony = By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]");
	By EmptyCartLinkBtn = By.xpath("//span[contains(text(),'Empty Cart')]");
	By ErrormsgMobileunexpectedQuantity = By.xpath("//span[contains(text(),'Some of the products cannot be ordered in requeste')]");
	By CartEmptyMsgText = By.xpath("//h1[normalize-space()='Shopping Cart is Empty']");
	By CompareButton = By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]");
	
	
			By SamsungGalaxy= By.xpath("//a[@title='Samsung Galaxy'][normalize-space()='Samsung Galaxy']");
			By SonyExperia = By.xpath("//a[@title='Sony Xperia']");
			By IPhone =     By.xpath("//a[@title='IPhone'][normalize-space()='IPhone'])");
			By SamsungAddToCompareBtn =By.xpath("(//a[@class='link-compare'])[1]");
			By SonyAddToCompBtn = By.xpath("(//a[@class='link-compare'])[2]");
			By IPhoneAddToCompbtn = By.xpath("(//a[@class='link-compare'])[3]");
		
	
	public MobileMenuPg(WebDriver driver){
		this.driver = driver;
	}
	
	public String MobilePgTitle() {
		String MobilePgtitle = driver.getTitle();
		return MobilePgtitle;
	}
	
	public void selectSortByDDMenu() {
		WebElement sortbydd1 = driver.findElement(sortbydd);
		sortbydd1.click();
		Select sortbydd = new Select(sortbydd1);
		sortbydd.selectByVisibleText("Name");
	}
	
	public void captureScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("E:\\Akshay Dashpute Official\\Eclipse\\ecommercesite4.6\\test-output\\Screenshots\\MobileMenuSS.png");
		FileUtils.copyFile(src, dst);
		
	}
	
	public void addToCartSonyMobile() {
		
		driver.findElement(addToCartSonyButton).click();
	}
	public void enterQuantitySonyMob(String qty) throws IOException {
		driver.findElement(qtyInputSonybtn).clear();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("E:\\Akshay Dashpute Official\\Eclipse\\ecommercesite4.6\\test-output\\Screenshots\\QuantitySonyMobile.png");
		FileUtils.copyFile(src, dst);
		driver.findElement(qtyInputSonybtn).sendKeys(qty);
		System.out.println("Enetered Quantity is "+qty);

		
	}
	
	public void clickOnUpdateBtn() {
		driver.findElement(updateBtnSony).click();
	}
	
	public String sonyMobileqtyErrorMsg() {
		String ErrormsgMobileQty = driver.findElement(ErrormsgMobileunexpectedQuantity).getText();
		return ErrormsgMobileQty;
	}
	
	public void clickOnEmptycart() {
		driver.findElement(EmptyCartLinkBtn).click();
	}
	public String cartEmptyMsg() {
		String EmptyCartMsg = driver.findElement(CartEmptyMsgText).getText();
		return EmptyCartMsg;
	}
	
	//Compare mobiles test
	
	public void selectMobilesForComparison(){
		driver.findElement(SonyAddToCompBtn).click();
		driver.findElement(IPhoneAddToCompbtn).click();
		
	}
	
	public void clickonCompareButtonAndSwithWindows(){
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent window handle is "+parentwindow);
		driver.findElement(CompareButton).click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!(handle.equalsIgnoreCase(parentwindow))) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				
				break;

			}
			
		}
	}
	
	public void verifyMobileComparisonWindow() throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("E:\\Akshay Dashpute Official\\Eclipse\\ecommercesite4.6\\test-output\\Screenshots\\MobileCompareWindow.png");
		FileUtils.copyFile(src, dst);
		/*String ActualSonyMobInComparePage = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']")).getText();
		String ExpectedSonyMobInComparePage = "SONY XPERIA";
		String ActualIPhoneMobInComparePage = driver.findElement(By.xpath("//a[normalize-space()='IPhone']")).getText();
		String ExpectedIPhoneMobComPage = "IPHONE";
		//String[] AlCompareMobileScreen = {ActualIPhoneMobInComparePage, ActualSonyMobInComparePage, ExpectedIPhoneMobComPage, ExpectedSonyMobInComparePage};
		
		//return AlCompareMobileScreen;*/

		
	}
	
	public void closeCompareWindow(){
		driver.switchTo().window(driver.getWindowHandle());
		System.out.println(driver.getWindowHandle());
	}
}
