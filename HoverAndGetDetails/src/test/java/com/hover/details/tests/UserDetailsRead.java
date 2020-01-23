package com.hover.details.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.hover.details.config.Config;
import com.hover.details.utils.Utils;

public class UserDetailsRead {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty(Config.CHROME_DRIVER_KEY, Config.Chrome_Driver_Path);
		System.out.println(" Windows OS Executing on Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/hovers");
	}

	@Test
	public void validateInvalidImages() throws InterruptedException {
		WebElement image1 = driver.findElement(By.xpath("//h5[text()='name: user1']/../.."));
		WebElement userDetails1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));

		WebElement image2 = driver.findElement(By.xpath("//h5[text()='name: user2']/../.."));
		WebElement userDetails2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));

		WebElement image3 = driver.findElement(By.xpath("//h5[text()='name: user3']/../.."));
		WebElement userDetails3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));

		Actions action = new Actions(driver);
		action.moveToElement(image1);
		Utils.highLightElement(driver, image1);
		action.build().perform();

		Utils.highLightElement(driver, userDetails1);
		assertEquals(userDetails1.getText().toString(), "name: user1");

		Thread.sleep(2000);

		action.moveToElement(image2);
		Utils.highLightElement(driver, image2);
		action.build().perform();

		Utils.highLightElement(driver, userDetails2);
		assertEquals(userDetails2.getText().toString(), "name: user2");

		Thread.sleep(2000);

		action.moveToElement(image3);
		Utils.highLightElement(driver, image3);
		action.build().perform();

		Utils.highLightElement(driver, userDetails3);
		assertEquals(userDetails3.getText().toString(), "name: user3");
	}
}
