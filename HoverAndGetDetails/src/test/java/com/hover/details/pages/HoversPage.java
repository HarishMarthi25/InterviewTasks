package com.hover.details.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hover.details.config.Config;
import com.hover.details.utils.Utils;

public class HoversPage {
	WebDriver driver;

	public HoversPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='name: user1']/../..")
	WebElement firstImage;

	@FindBy(xpath = "//h5[text()='name: user2']/../..")
	WebElement secondImage;

	@FindBy(xpath = "//h5[text()='name: user3']/../..")
	WebElement thirdImage;

	@FindBy(xpath = "//h5[text()='name: user1']")
	WebElement userDetails1;

	@FindBy(xpath = "//h5[text()='name: user2']")
	WebElement userDetails2;

	@FindBy(xpath = "//h5[text()='name: user3']")
	WebElement userDetails3;

	@FindBy(xpath = "//h3[text()='Hovers']")
	WebElement hoverHeaderText;

	@FindBy(xpath = "//div[text()='Powered by ']")
	WebElement poweredByText;

	@FindBy(xpath = "//p[text()='Hover over the image for additional information']")
	WebElement hoverHeaderDescriptionText;

	public void verifyHeaderText(String hoverHeader) throws InterruptedException {
		if (hoverHeaderText.isDisplayed()) {
			Utils.highLightElement(driver, hoverHeaderText);
			assertEquals(hoverHeaderText.getText().toString(), hoverHeader);
		}
	}

	public void verifyHeaderDescriptionText(String descriptionText) throws InterruptedException {
		if (hoverHeaderDescriptionText.isDisplayed()) {
			Utils.highLightElement(driver, hoverHeaderDescriptionText);
			assertEquals(hoverHeaderDescriptionText.getText().toString(), descriptionText);
		}
	}

	public void hoverOnImageOne() throws InterruptedException {
		if (firstImage.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(firstImage);
			Utils.highLightElement(driver, firstImage);
			action.build().perform();
		}
	}

	public void verifyFirstImageUserName(String userNameOne) throws InterruptedException {
		if (userDetails1.isDisplayed()) {
			Utils.highLightElement(driver, userDetails1);
			assertEquals(userDetails1.getText().toString(), userNameOne);
			Thread.sleep(2000);
		}
	}

	public void hoverOnImageTwo() throws InterruptedException {
		if (secondImage.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(secondImage);
			Utils.highLightElement(driver, secondImage);
			action.build().perform();
		}
	}

	public void verifySecondImageUserName(String userNameTwo) throws InterruptedException {
		if (userDetails2.isDisplayed()) {
			Utils.highLightElement(driver, userDetails2);
			assertEquals(userDetails2.getText().toString(), userNameTwo);
			Thread.sleep(2000);
		}
	}

	public void hoverOnImageThree() throws InterruptedException {
		if (thirdImage.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(thirdImage);
			Utils.highLightElement(driver, thirdImage);
			action.build().perform();
		}
	}

	public void verifyThirdImageUserName(String userNameThree) throws InterruptedException {
		if (userDetails3.isDisplayed()) {
			Utils.highLightElement(driver, userDetails3);
			assertEquals(userDetails3.getText().toString(), userNameThree);
			Thread.sleep(2000);
		}
	}

	public void verifyPoweredByText(String poweredByTextValue) throws InterruptedException {
		if (poweredByText.isDisplayed()) {
			Utils.highLightElement(driver, poweredByText);
			assertEquals(poweredByText.getText().toString(), poweredByTextValue);
			Thread.sleep(2000);
		}
	}
	
	public void lunchHoverApp() {
		driver.get(Config.AppUrl);
	}
	
	public void closeApplication(){
		driver.close();
	}

}
