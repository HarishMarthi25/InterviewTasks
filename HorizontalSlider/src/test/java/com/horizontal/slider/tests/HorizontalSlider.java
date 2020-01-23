package com.horizontal.slider.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.horizontal.slider.config.Config;
import com.horizontal.slider.utils.Utils;

public class HorizontalSlider {

	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty(Config.CHROME_DRIVER_KEY, Config.Chrome_Driver_Path);
		System.out.println(" Windows OS Executing on Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
	}

	@Test
	public void validateInvalidImages() throws InterruptedException {

		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		WebElement sliderRangeValue = driver.findElement(By.xpath("//span[@id='range']"));
		WebElement sliderContainer = driver.findElement(By.xpath("//div[@class='sliderContainer']"));

		Utils.highLightElement(driver, sliderContainer);
		Actions move = new Actions(driver);
		Action action = move.dragAndDropBy(slider, 100, 0).build();
		action.perform();
		Utils.highLightElement(driver, sliderRangeValue);
		assertEquals(sliderRangeValue.getText().toString(), "5");

		Utils.highLightElement(driver, sliderContainer);
		Action action1 = move.dragAndDropBy(slider, -100, 0).build();
		action1.perform();
		Utils.highLightElement(driver, sliderRangeValue);
		assertEquals(sliderRangeValue.getText().toString(), "0");
	}

}
