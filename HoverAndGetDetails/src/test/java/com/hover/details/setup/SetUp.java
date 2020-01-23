package com.hover.details.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hover.details.config.Config;

public class SetUp {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver==null) {
			System.setProperty(Config.CHROME_DRIVER_KEY, Config.Chrome_Driver_Path);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
		
	}
}
