package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage {
	
	WebDriver driver;
	public  RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By First_Name = By.id("firstname");
	By Last_Name= By.id("lastname");
	By EMail_id = By.cssSelector("input[id='email_address']");
	By password = By.xpath("//input[@id='password']");
	By Confirm_password = By.xpath("//input[@id='confirmation']");
	By register_Btn = By.xpath("//span[contains(text(),'Register')]");
	By regi_succefull_msg = By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']");
	
	public void sendUserInformation() throws IOException {
		File file = new File("C:\\Users\\User\\Desktop\\Akshay\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("registerdetails");
		int rowNumbers = sh.getLastRowNum();
		
		XSSFRow firstRow = sh.getRow(0);
		int columnNum= firstRow.getLastCellNum();
		
		
		for(int i = 2; i<=rowNumbers; i++) {
			
				
				String FirstName = sh.getRow(i).getCell(0).getStringCellValue();
				String LastName = sh.getRow(i).getCell(2).getStringCellValue();
				String Email = sh.getRow(i).getCell(3).getStringCellValue();
				String Pwd = sh.getRow(i).getCell(4).getStringCellValue();
				String ConfirmPwd = sh.getRow(i).getCell(5).getStringCellValue();
				 driver.findElement(First_Name).sendKeys(FirstName);
				 driver.findElement(Last_Name).sendKeys(LastName);
				 driver.findElement(EMail_id).sendKeys(Email);
				 driver.findElement(password).sendKeys(Pwd);
				 driver.findElement(Confirm_password).sendKeys(ConfirmPwd);
				 driver.findElement(register_Btn).click();
				
				
			
		}
		
		
		
	}
	public String getRegitrationMsg() {
		
		//String expectedregistrationMsg = "Thank you for registering with Main Website Store.";
		String actualregistrationMsg= driver.findElement(regi_succefull_msg).getText();
		return actualregistrationMsg;
		
	}
	
	public void getScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("C:\\Users\\User\\eclipse-workspace\\ecommercesite4.6\\test-output\\Screenshots\\RegistrationCompletion.png");
		FileUtils.copyFile(src, dst);
	}
	
}
