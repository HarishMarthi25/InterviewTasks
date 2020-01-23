package com.hover.details.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.hover.details.setup.SetUp;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;

public class Hooks {
	
	@AfterStep
	public void addScreenShotToReport(Scenario scenario) {
		try {
			byte[] screenShot = ((TakesScreenshot) SetUp.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenShot, "image/png");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		
	}

}
