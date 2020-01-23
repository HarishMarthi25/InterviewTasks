package com.basic.auth.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basic.auth.TestBase;
import com.basic.auth.config.Config;
import com.basic.auth.utils.ReportUtil;
import com.basic.auth.utils.Utils;

public class LoginAutomationSite extends TestBase {

	@DataProvider(name = "testData")
	public Object[][] dataSource() {
		return getData(Config.TestDataSheetPath, "test");
	}

	@Test(dataProvider = "testData")
	public void doLogin(String username, String password) throws Exception {
		String finalURL = Config.HTTPSBASE + username + ":" + password + "@" + Config.AppUrl;
		driver.get(finalURL);
		System.out.println(" ************ finalURL:" + finalURL);
		ReportUtil.addKeyword("Login into Automattion Site", "Login", "Pass", null);
	}

	@Test
	public void verifySuccessResponseText() throws Exception {
		WebElement baiscAuthHeaderText = driver.findElement(By.xpath("//h3[text()='Basic Auth']"));
		Utils.highLightElement(driver, baiscAuthHeaderText);
		assertEquals(baiscAuthHeaderText.getText().toString(), "Basic Auth");

		WebElement baiscAuthMessage = driver.findElement(By.xpath("//*[@id='content']/div/p"));
		Utils.highLightElement(driver, baiscAuthMessage);
		assertEquals(baiscAuthMessage.getText().toString(), "Congratulations! You must have the proper credentials.");
	}

}
