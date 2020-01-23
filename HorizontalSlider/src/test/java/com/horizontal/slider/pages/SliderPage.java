package com.horizontal.slider.pages;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.horizontal.slider.utils.Utils;

public class SliderPage {

	WebDriver driver;

	public SliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Horizontal Slider']")
	WebElement sliderHeaderText;

	@FindBy(xpath = "//h4[@class='subheader']")
	WebElement sliderSubHeaderText;

	@FindBy(xpath = "//input[@type='range']")
	WebElement slider;

	@FindBy(xpath = "//div[@class='sliderContainer']")
	WebElement sliderContainer;

	@FindBy(xpath = "//span[@id='range']")
	WebElement sliderRangeValue;

	@FindBy(xpath = "//div[text()='Powered by ']")
	WebElement poweredByText;

	public void verifyHeaderText(String sliderHeader) throws InterruptedException {
		if (sliderHeaderText.isDisplayed()) {
			Utils.highLightElement(driver, sliderHeaderText);
			assertEquals(sliderHeaderText.getText().toString(), sliderHeader);
		}
	}

	public void verifySubHeaderText(String sliderSubHeader) throws InterruptedException {
		if (sliderSubHeaderText.isDisplayed()) {
			Utils.highLightElement(driver, sliderSubHeaderText);
			assertEquals(sliderSubHeaderText.getText().toString(), sliderSubHeader);
		}
	}

	public void verifySliderDisplayedOrNot() throws InterruptedException {
		assertTrue(slider.isDisplayed());
		Utils.highLightElement(driver, slider);
	}

	public void verifySliderContainerDisplayedOrNot() throws InterruptedException {
		assertTrue(sliderContainer.isDisplayed());
		Utils.highLightElement(driver, sliderContainer);
	}

	public void verifysliderRangeValueDisplayedOrNot() throws InterruptedException {
		assertTrue(sliderRangeValue.isDisplayed());
		Utils.highLightElement(driver, sliderRangeValue);
	}

	public void verifypoweredByTextDisplayedOrNot() throws InterruptedException {
		assertTrue(poweredByText.isDisplayed());
		Utils.highLightElement(driver, poweredByText);
	}

	public void verifysliderRangeValueAsMinValue(String minRange) throws InterruptedException {
		if (sliderRangeValue.isDisplayed()) {
			Utils.highLightElement(driver, sliderContainer);
			Actions move = new Actions(driver);
			Action action1 = move.dragAndDropBy(slider, -100, 0).build();
			action1.perform();
			Utils.highLightElement(driver, sliderRangeValue);
			assertEquals(sliderRangeValue.getText().toString(), minRange);
		}
	}

	public void verifysliderRangeValueAsMaxValue(String maxRange) throws InterruptedException {
		if (sliderRangeValue.isDisplayed()) {
			Utils.highLightElement(driver, sliderContainer);
			Actions move = new Actions(driver);
			Action action = move.dragAndDropBy(slider, 100, 0).build();
			action.perform();
			Utils.highLightElement(driver, sliderRangeValue);
			assertEquals(sliderRangeValue.getText().toString(), maxRange);

		}
	}

}
