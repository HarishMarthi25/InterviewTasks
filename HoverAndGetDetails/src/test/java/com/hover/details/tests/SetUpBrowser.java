package com.hover.details.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hover.details.config.Config;

public class SetUpBrowser {
	WebDriver driver;

	public void launchBrowser(WebDriver driver) {
		System.setProperty(Config.CHROME_DRIVER_KEY, Config.Chrome_Driver_Path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Config.AppUrl);
	}

	public void launchedPageSuccessFully() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");
	}

}
