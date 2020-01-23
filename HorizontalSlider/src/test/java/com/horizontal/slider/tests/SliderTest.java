package com.horizontal.slider.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.horizontal.slider.config.Config;
import com.horizontal.slider.pages.SliderPage;

public class SliderTest {

	WebDriver driver;
	SliderPage slidePage;

	@BeforeTest
	public void setup() {
		System.setProperty(Config.CHROME_DRIVER_KEY, Config.Chrome_Driver_Path);
		System.out.println(" Windows OS Executing on Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Config.AppUrl);
		slidePage = new SliderPage(driver);
	}

	@Test
	public void verifyAllElements() throws InterruptedException {
		slidePage.verifyHeaderText("Horizontal Slider");
		slidePage.verifySubHeaderText(
				"Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left. Or click and drag the slider with your mouse. It will indicate the value of the slider to the right.");
		slidePage.verifySliderDisplayedOrNot();
		slidePage.verifySliderContainerDisplayedOrNot();
		slidePage.verifysliderRangeValueDisplayedOrNot();
		slidePage.verifypoweredByTextDisplayedOrNot();
	}

	@Test
	public void verifySliderMinValueAsZero() throws InterruptedException {
		slidePage.verifysliderRangeValueAsMinValue("0");
	}

	@Test
	public void verifySliderMaxValueAsFive() throws InterruptedException {
		slidePage.verifysliderRangeValueAsMaxValue("5");
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
