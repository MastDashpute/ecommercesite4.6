package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver intializeDriver(String browser) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		if(browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			//System.setProperty("tdriver.chrome.driver", "E:\\Akshay Dashpute Official\\Chrome driver\\chromedriver.exe");
			tdriver.set(new ChromeDriver(options)); 
		}else {
			System.out.println(browser +"borwser not supported");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	/*public static void main(String[] args) {
		BaseDriver bd = new BaseDriver();
		bd.intializeDriver("chrome");
		*/
}

