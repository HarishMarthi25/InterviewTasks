package com.hover.details.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
	public static String now(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat();
		return fm.format(cal.getTime());
	}

	public static void highLightElement(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	}
}
